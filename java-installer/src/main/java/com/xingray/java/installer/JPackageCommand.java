package com.xingray.java.installer;



import com.xingray.java.command.annotations.Command;
import com.xingray.java.command.annotations.KeyValueLinker;

import java.util.List;

@Command("jpackage")
@KeyValueLinker(" ")
public class JPackageCommand {

    private Boolean verbose;
    private String runtimeImage;
    private String type;
    private String icon;
    private String dest;
    private String temp;
    private String appVersion;
    private String copyright;
    private String description;
    private String name;
    private String vendor;
    private Boolean winDirChooser;
    private Boolean winShortcut;
    private String installDir;
    private String resourceDir;
    private String input;
    private String mainJar;
    private String mainClass;
    private String module;
    private String addModules;
    private List<String> modulePath;

    private List<String> javaOptions;

    public Boolean getVerbose() {
        return verbose;
    }

    public void setVerbose(Boolean verbose) {
        this.verbose = verbose;
    }

    public String getRuntimeImage() {
        return runtimeImage;
    }

    public void setRuntimeImage(String runtimeImage) {
        this.runtimeImage = runtimeImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Boolean getWinDirChooser() {
        return winDirChooser;
    }

    public void setWinDirChooser(Boolean winDirChooser) {
        this.winDirChooser = winDirChooser;
    }

    public Boolean getWinShortcut() {
        return winShortcut;
    }

    public void setWinShortcut(Boolean winShortcut) {
        this.winShortcut = winShortcut;
    }

    public String getInstallDir() {
        return installDir;
    }

    public void setInstallDir(String installDir) {
        this.installDir = installDir;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAddModules() {
        return addModules;
    }

    public void setAddModules(String addModules) {
        this.addModules = addModules;
    }

    public String getResourceDir() {
        return resourceDir;
    }

    public void setResourceDir(String resourceDir) {
        this.resourceDir = resourceDir;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getMainJar() {
        return mainJar;
    }

    public void setMainJar(String mainJar) {
        this.mainJar = mainJar;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public List<String> getModulePath() {
        return modulePath;
    }

    public void setModulePath(List<String> modulePath) {
        this.modulePath = modulePath;
    }

    public List<String> getJavaOptions() {
        return javaOptions;
    }

    public void setJavaOptions(List<String> javaOptions) {
        this.javaOptions = javaOptions;
    }

    @Override
    public String toString() {
        return "JPackageCommand{" +
                "verbose=" + verbose +
                ", runtimeImage='" + runtimeImage + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                ", dest='" + dest + '\'' +
                ", temp='" + temp + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", copyright='" + copyright + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                ", winDirChooser=" + winDirChooser +
                ", winShortcut=" + winShortcut +
                ", installDir='" + installDir + '\'' +
                ", resourceDir='" + resourceDir + '\'' +
                ", input='" + input + '\'' +
                ", mainJar='" + mainJar + '\'' +
                ", mainClass='" + mainClass + '\'' +
                ", module='" + module + '\'' +
                ", addModules='" + addModules + '\'' +
                ", modulePath=" + modulePath +
                ", javaOptions=" + javaOptions +
                '}';
    }
}
