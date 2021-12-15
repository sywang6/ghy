package org.ghy.multiThreadFrame.ch10.ch03_02;

public class Userinfo implements  Comparable<Userinfo>{
    private int id;

    public Userinfo() {
    }

    public Userinfo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Userinfo o) {
        if(this.id<o.id){
            return  -1;
        }
        if(this.id>o.getId()){
            return  1;
        }
        return 0;
    }
}
