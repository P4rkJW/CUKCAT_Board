package com.example.demo6.Domain;

public class Board {
    private int seq;
    private String file;
    private String title;
    private String content;
    private String newfile;
    private String newtitle;
    private String newcontent;
    private int recommand;
    private int oppose;

    public void setSeq(int seq){ this.seq = seq; }

    public void setFile(String file){
        this.file = file;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setNewfile(String newfile) { this.newfile = newfile; }

    public void setNewtitle(String newtitle) { this.newtitle = newtitle; }

    public void setNewcontent(String newcontent) { this.newcontent = newcontent; }

    public String getTitle() { return title; }

    public String getFile() { return file; }

    public int getSeq() { return seq; }

    public int getRecommand() { return recommand; }

    public int getOppose() { return  oppose; }

}
