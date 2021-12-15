package org.ghy.multiThreadFrame.ch10.ch02_03;

public class Userinfo implements Comparable<Userinfo>{

    private int id;
    private String username;

    public Userinfo() {
    }

    public Userinfo(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(Userinfo o) {
        if(this.getId()<o.getId()){
            return -1;
        }
        if(this.getId()>o.getId()){
            return 1;
        }
        return 0;
    }

    public int hashCode(){
        final  int prime =31;
        int result =1;
        result = prime*result+id;
        result = prime*result+((username==null)?0:username.hashCode());
        return result;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return  true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        Userinfo other = (Userinfo)obj;
        if(id!=other.id){
            return false;
        }
        if(username==null){
            if(other.username!=null){
                return false;
            }
        }else if(!username.equals(other.username)){
            return false;
        }
        return true;
    }

}
