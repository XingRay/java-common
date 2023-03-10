package com.xingray.java.util;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

public class SystemUtil {

    public static String openDirectory(String directoryPath) {
        String osName = getSystemName();

        if (osName.contains("windows")) {
            try {
                Runtime.getRuntime().exec("explorer.exe " + directoryPath);
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        } else {
            return "暂不支持此系统：" + osName;
        }
    }

    public static String getUserDirectory() {
        return System.getProperty("user.dir");
    }

    public static String getPath(String relativePath) {
        return getUserDirectory() + relativePath;
    }

    public static void printSystem() {
        Runtime r = Runtime.getRuntime();
        Properties properties = System.getProperties();
        InetAddress addr;
        String ip = null;
        String hostName = null;
        try {
            addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
            hostName = addr.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Map<String, String> env = System.getenv();
        String userName = env.get("USERNAME");// 获取用户名
        String computerName = env.get("COMPUTERNAME");// 获取计算机名
        String userDomain = env.get("USERDOMAIN");// 获取计算机域名

        System.out.println("用户名:    " + userName);
        System.out.println("计算机名:    " + computerName);
        System.out.println("计算机域名:    " + userDomain);
        System.out.println("本地ip地址:    " + ip);
        System.out.println("本地主机名:    " + hostName);
        System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
        System.out.println("JVM可以使用的剩余内存:    " + r.freeMemory());
        System.out.println("JVM可以使用的处理器个数:    " + r.availableProcessors());
        System.out.println("Java的运行环境版本：    " + properties.getProperty("java.version"));
        System.out.println("Java的运行环境供应商：    " + properties.getProperty("java.vendor"));
        System.out.println("Java供应商的URL：    " + properties.getProperty("java.vendor.url"));
        System.out.println("Java的安装路径：    " + properties.getProperty("java.home"));
        System.out.println("Java的虚拟机规范版本：    " + properties.getProperty("java.vm.specification.version"));
        System.out.println("Java的虚拟机规范供应商：    " + properties.getProperty("java.vm.specification.vendor"));
        System.out.println("Java的虚拟机规范名称：    " + properties.getProperty("java.vm.specification.name"));
        System.out.println("Java的虚拟机实现版本：    " + properties.getProperty("java.vm.version"));
        System.out.println("Java的虚拟机实现供应商：    " + properties.getProperty("java.vm.vendor"));
        System.out.println("Java的虚拟机实现名称：    " + properties.getProperty("java.vm.name"));
        System.out.println("Java运行时环境规范版本：    " + properties.getProperty("java.specification.version"));
        System.out.println("Java运行时环境规范供应商：    " + properties.getProperty("java.specification.vender"));
        System.out.println("Java运行时环境规范名称：    " + properties.getProperty("java.specification.name"));
        System.out.println("Java的类格式版本号：    " + properties.getProperty("java.class.version"));
        System.out.println("Java的类路径：    " + properties.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表：    " + properties.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径：    " + properties.getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展目录的路径：    " + properties.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称：    " + properties.getProperty("os.name"));
        System.out.println("操作系统的构架：    " + properties.getProperty("os.arch"));
        System.out.println("操作系统的版本：    " + properties.getProperty("os.version"));
        System.out.println("文件分隔符：    " + properties.getProperty("file.separator"));
        System.out.println("路径分隔符：    " + properties.getProperty("path.separator"));
        System.out.println("行分隔符：    " + properties.getProperty("line.separator"));
        System.out.println("用户的账户名称：    " + properties.getProperty("user.name"));
        System.out.println("用户的主目录：    " + properties.getProperty("user.home"));
        System.out.println("用户的当前工作目录：    " + properties.getProperty("user.dir"));

        System.out.println("=============   System.getProperties()   =============");
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("=============   System.getenv()   ===============");
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static boolean isRunOnWindows() {
        String osName = getSystemName();
        return osName.contains("windows");
    }

    public static String getSystemName() {
        return System.getProperty("os.name").toLowerCase();
    }
}
