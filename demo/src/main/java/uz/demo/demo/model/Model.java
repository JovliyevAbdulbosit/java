package uz.demo.demo.model;

public class Model {
 private int id;
 private String name;
 private String age;

 public void setId(int id) {
  this.id = id;
 }

 public void setName(String name) {
  this.name = name;
 }

 public void setAge(String age) {
  this.age = age;
 }

 public int getId() {
  return id;
 }

 public String getName() {
  return name;
 }

 public String getAge() {
  return age;
 }
public String info(){
  return this.id+this.name+this.age;
}
}
