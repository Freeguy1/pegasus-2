/*
 * 
 *   Copyright 2007-2008 University Of Southern California
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 */

package edu.isi.pegasus.common.logging;

import org.griphyn.common.util.FactoryException;

/**
 * Class to notify of failures while instantiating Log Formatter
 * implementations.
 *
 * @author Karan Vahi
 * @version $Revision$
 */

public class LogFormatterFactoryException extends FactoryException {

    /**
     * The default classname that is associated with the exception.
     */
    public static final String DEFAULT_NAME = "Log Formatter";


    /**
     * Constructs a <code>LogFormatterFactoryException</code> with no detail
     * message. The associated classname is set to value specified by
     * <code>DEFAULT_NAME</code>.
     *
     * @param msg the detailed message.
     *
     * @see #DEFAULT_NAME
     */
    public LogFormatterFactoryException( String msg ) {
        super( msg );
        mClassname = LogFormatterFactoryException.DEFAULT_NAME;
    }

    /**
     * Constructs a <code>LogFormatterFactoryException</code> with the specified detailed
     * message.
     *
     * @param msg       is the detailed message.
     * @param classname the name of class that was trying to be instantiated or
     *                  some other signifier like module name.
     */
    public LogFormatterFactoryException(String msg, String classname) {
        super( msg , classname );
    }


    /**
     * Constructs a <code>LogFormatterFactoryException</code> with the
     * specified detailed message and a cause. The associated classname is set
     * to value specified by <code>DEFAULT_NAME</code>.
     *
     * @param msg       is the detailed message that is to be logged.
     * @param cause is the cause (which is saved for later retrieval by the
     * {@link java.lang.Throwable#getCause()} method). A <code>null</code>
     * value is permitted, and indicates that the cause is nonexistent or
     * unknown.
     *
     * @see #DEFAULT_NAME
     */
    public LogFormatterFactoryException(String msg, Throwable cause) {
        super(msg, cause);
        mClassname = LogFormatterFactoryException.DEFAULT_NAME;
    }


    /**
     * Constructs a <code>LogFormatterFactoryException</code> with the
     * specified detailed message and a cause.
     *
     * @param msg       is the detailed message that is to be logged.
     * @param classname the name of class that was trying to be instantiated.
     * @param cause is the cause (which is saved for later retrieval by the
     * {@link java.lang.Throwable#getCause()} method). A <code>null</code>
     * value is permitted, and indicates that the cause is nonexistent or
     * unknown.
     */
    public LogFormatterFactoryException( String msg,
                                        String classname,
                                        Throwable cause ) {

        super( msg, cause );
        mClassname = classname;
    }


}
