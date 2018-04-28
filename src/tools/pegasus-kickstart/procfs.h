#ifndef KICKSTART_PROCFS_H
#define KICKSTART_PROCFS_H

#include <unistd.h>
#include <time.h>
#include <netinet/in.h>

typedef enum { PROCFS, INTERPOSE, MERGED } ProcType;

typedef struct _ProcStats {
    ProcType type;
    double ts;
    in_addr_t host;
    pid_t pid;
    pid_t ppid;
    unsigned int rank;
    unsigned long long rchar;
    unsigned long long wchar;
    unsigned long syscr;
    unsigned long syscw;
    unsigned long long read_bytes;
    unsigned long long write_bytes;
    unsigned long long cancelled_write_bytes;
    double utime;
    double stime;
    double iowait;
    unsigned long long vmpeak; /* peak vm size */
    unsigned long long vm; /* current VM size */
    unsigned long long rsspeak; /* peak RSS */
    unsigned long long rss; /* current RSS */
    unsigned int procs;
    unsigned int threads;
#ifdef HAS_PAPI
    long long totins; /* Total instructions */
    long long ldins; /* Load instructions */
    long long srins; /* Store instructions */
    long long fpins; /* Floating point instructions */
    long long fpops; /* Floating point ops */
    long long l3misses; /* L3 cache misses */
    long long l2misses; /* L2 cache misses */
    long long l1misses; /* L1 cache misses */
#endif
    unsigned long long bsend; /* Bytes sent on sockets (libinterpose only) */
    unsigned long long brecv; /* Bytes recvd on sockets (libinterpose only) */
    char exe[128];
} ProcStats;

typedef struct _ProcStatsList {
    ProcStats stats;
    struct _ProcStatsList *next;
} ProcStatsList;

void procfs_stats_init(ProcStats *stats);
int procfs_read_stats(pid_t process, ProcStats *stats);
void procfs_read_stats_group(ProcStatsList **listptr);
void procfs_merge_stats_list(ProcStatsList *list, ProcStats *result, int interval);
void procfs_free_stats_list(ProcStatsList *list);
ProcStatsList *procfs_list_find(ProcStatsList **list, in_addr_t host, pid_t pid);
void procfs_list_update(ProcStatsList **list, ProcStats *stats);

#endif