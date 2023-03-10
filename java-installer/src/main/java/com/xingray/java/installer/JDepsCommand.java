package com.xingray.java.installer;



import com.xingray.java.command.annotations.Command;
import com.xingray.java.command.annotations.NoCommandKey;

import java.util.List;

@Command("jdeps")
public class JDepsCommand {

    private Integer multiRelease;
    private Boolean printModuleDeps;
    private Boolean ignoreMissingDeps;
    private Boolean recursive;
    private List<String> addModules;
    private List<String> classPath;
    private List<String> modulePath;

    @NoCommandKey
    private String target;

    public Integer getMultiRelease() {
        return multiRelease;
    }

    public void setMultiRelease(Integer multiRelease) {
        this.multiRelease = multiRelease;
    }

    public Boolean getPrintModuleDeps() {
        return printModuleDeps;
    }

    public void setPrintModuleDeps(Boolean printModuleDeps) {
        this.printModuleDeps = printModuleDeps;
    }

    public Boolean getIgnoreMissingDeps() {
        return ignoreMissingDeps;
    }

    public void setIgnoreMissingDeps(Boolean ignoreMissingDeps) {
        this.ignoreMissingDeps = ignoreMissingDeps;
    }

    public Boolean getRecursive() {
        return recursive;
    }

    public void setRecursive(Boolean recursive) {
        this.recursive = recursive;
    }

    public List<String> getAddModules() {
        return addModules;
    }

    public void setAddModules(List<String> addModules) {
        this.addModules = addModules;
    }

    public List<String> getClassPath() {
        return classPath;
    }

    public void setClassPath(List<String> classPath) {
        this.classPath = classPath;
    }

    public List<String> getModulePath() {
        return modulePath;
    }

    public void setModulePath(List<String> modulePath) {
        this.modulePath = modulePath;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "JdepsCommand{" +
                "multiRelease=" + multiRelease +
                ", printModuleDeps=" + printModuleDeps +
                ", ignoreMissingDeps=" + ignoreMissingDeps +
                ", recursive=" + recursive +
                ", addModules=" + addModules +
                ", classPath=" + classPath +
                ", modulePath=" + modulePath +
                ", target='" + target + '\'' +
                '}';
    }
}
