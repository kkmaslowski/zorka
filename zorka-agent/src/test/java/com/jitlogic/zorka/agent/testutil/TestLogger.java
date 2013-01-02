/**
 * Copyright 2012 Rafal Lewczuk <rafal.lewczuk@jitlogic.com>
 * <p/>
 * This is free software. You can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this software. If not, see <http://www.gnu.org/licenses/>.
 */

package com.jitlogic.zorka.agent.testutil;

import com.jitlogic.zorka.integ.ZorkaLogLevel;
import com.jitlogic.zorka.util.ZorkaLogger;

import java.util.ArrayList;
import java.util.List;

public class TestLogger extends ZorkaLogger {

    public static class LogRecord {
        public final String tag;
        public final ZorkaLogLevel level;
        public final String message;
        public final Throwable e;

        public LogRecord(String tag, ZorkaLogLevel level, String message, Throwable e) {
            this.tag = tag;
            this.level = level;
            this.message = message;
            this.e = e;
        }
    }

    private List<LogRecord> logs = new ArrayList<LogRecord>();

    public synchronized void log(String tag, ZorkaLogLevel logLevel, String message, Throwable e, Object...args) {
        logs.add(new LogRecord(tag, logLevel, message, e));
    }

    public int size() {
        return logs.size();
    }

    public LogRecord get(int idx) {
        return logs.get(idx);
    }
}
