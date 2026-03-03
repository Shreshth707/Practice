/* 
// Features
1. Different Log Levels
2. Different Log Formats
3. Different Output Appenders/Writers
4. Aysnc Log Processing with Queue to handle the back pressure.
5. Performance 
*/

/* 
// Patterns Used
1. Chain Of Responsibility (Can Use or Not Use)
2. Factory Pattern (Different Log Formats)
3. Strategy Pattern (Formatter/OututAppender)
 */

enum LogLevel {
    INFO,
    WARN,
    ERROR,
    DEBUG,
    TRACE
}

enum LogFormat {
    JSON,
    STRING,
    XML,
    CSV
}

enum OutputAppender {
    FILE,
    CONSOLE,
    DATABASE
}

class LogRecord {
    private LogLevel level;
    private String message;
    private String timestamp;
}

public interface Formatter {
    String format(LogEvent event);
}

public class JsonFormatter implements Formatter {
    @Override
    public String format(LogEvent event) {
        //    Business Logic
    }
}

public interface Appender {
    void append(LogRecord record);
    void close();
}

class FileAppender implements Appender {
    
    private String fileName;
    
    private final Formatter formatter;
    public FileAppender(String fileName, Formatter formatter) {
        this.fileName = fileName;
        this.formatter = new Formatter();
    }
    public void append(LogRecord record) {
        formatter.format(record);
        // Business Logic
    }

    @Override
    public void close() {
        // Business Logic
    }
}

public class ConsoleAppender implements Appender {
    private final Formatter formatter;
    public ConsoleAppender(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogRecord logRecord) {
        formatter.format(logRecord)
        // Business Logic
    }

    @Override
    public void close() {
        // Business Logic
    }
}


class AsyncDispatcher {
    private final ExecutorService executorService;
    private final List<Appender> appenders;
    private final BlockingQueue<LogRecord> queue;

    public AsyncDispatcher(List<Appender> appenders) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.appenders = appenders;
        this.queue = new ArrayBlockingQueue<>(1000);
        this.start();
    }

    public void start() {
        executorService.execute(() -> {
            while (true) {
                try {
                    LogRecord record = queue.take();
                    dispatch(record);
                }
            }
        });

    public void dispatch(LogRecord record) {
        if (!queue.offer(record)) {
            // Handle the back pressure
        }
    }
}

class Logger {
    
    private String name;
    private LogLevel level;
    private final AsyncDispatcher dispatcher;

    public Logger(String name, LogLevel threshold, AsyncDispatcher dispatcher) {
        this.name = name;
        this.threshold = threshold;
        this.dispatcher = dispatcher;
    }

    public boolean isEnabled(LogLevel level) {
        return level.getPriority() >= threshold.getPriority();
    }

    public void log(LogLevel level, String message) {
        if (isEnabled(level)) {
            LogRecord record = new LogRecord(level, message, timestamp);
            dispatcher.dispatch(record);
        }
    }
}

public class LoggerFactory {
    private static final Map<String, Logger> loggers = new HashMap<>();

    public static Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, Logger::new);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("MyLogger");
        logger.log(LogLevel.INFO, "This is a test log");
    }
}