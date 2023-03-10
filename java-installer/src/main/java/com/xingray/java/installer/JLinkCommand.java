package com.xingray.java.installer;


import com.xingray.java.command.annotations.Command;
import com.xingray.java.command.annotations.KeyValueLinker;

@Command("jlink")
@KeyValueLinker(" ")
public class JLinkCommand {

    //--strip-native-commands --strip-debug --no-man-pages --no-header-filesjlink

    private String addModules;

    private String output;

    private Boolean stripNativeCommands;
    private Boolean stripDebug;
    private Boolean noManPages;
    private Boolean noHeaderFilesjlink;

    public String getAddModules() {
        return addModules;
    }

    public void setAddModules(String addModules) {
        this.addModules = addModules;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Boolean getStripNativeCommands() {
        return stripNativeCommands;
    }

    public void setStripNativeCommands(Boolean stripNativeCommands) {
        this.stripNativeCommands = stripNativeCommands;
    }

    public Boolean getStripDebug() {
        return stripDebug;
    }

    public void setStripDebug(Boolean stripDebug) {
        this.stripDebug = stripDebug;
    }

    public Boolean getNoManPages() {
        return noManPages;
    }

    public void setNoManPages(Boolean noManPages) {
        this.noManPages = noManPages;
    }

    public Boolean getNoHeaderFilesjlink() {
        return noHeaderFilesjlink;
    }

    public void setNoHeaderFilesjlink(Boolean noHeaderFilesjlink) {
        this.noHeaderFilesjlink = noHeaderFilesjlink;
    }

    @Override
    public String toString() {
        return "JLinkCommand{" +
                "addModules='" + addModules + '\'' +
                ", output='" + output + '\'' +
                ", stripNativeCommands=" + stripNativeCommands +
                ", stripDebug=" + stripDebug +
                ", noManPages=" + noManPages +
                ", noHeaderFilesjlink=" + noHeaderFilesjlink +
                '}';
    }
}
