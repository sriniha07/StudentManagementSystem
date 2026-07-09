package com.example.project.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity{
    @Id
    private int id;
    private String name;
    private int regno;
    private String dept;
    private String email;
    private long phone;
public StudentEntity(int id,String name,int regno,String dept,String email,long phone){
    this.id=id;
    this.name=name;
    this.regno=regno;
    this.dept=dept;
    this.email=email;
    this.phone=phone;
}
public void setId(int id){
    this.id=id;
}
public int getId(){
    return id;
}
public void setName(String name){
    this.name=name;
}
public String getName(){
    return name;
}
public void setRegno(int regno){
    this.regno=regno;
}
public int getRegno(){
    return regno;
}
public void setDept(String dept){
    this.dept=dept;
}
public String getDept(){
    return dept;
}
public void setEmail(String email){
    this.email=email;
}
public String getEmail(){
    return email;
}
public void setPhone(long phone){
    this.phone=phone;
}
public long getPhone(){
    return phone;
}

}