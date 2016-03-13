package com.main.java.form;

import java.util.ArrayList;
import java.util.List;

public class UserInfo{
    private String gender;
    private int age;
    private List<String> interests;
    private List<String> pastOrderNumbers;
    private String email;
    
    public UserInfo( ){
        LoadUser();
    }
    
    public UserInfo( String email, String gender, int age, List<String> interests ){
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.interests = interests;
        this.pastOrderNumbers = new ArrayList<String>(){};
    }

    private void SaveUser(){
        /* Vista breyturnar uppi í MyDocs? */

    }
    private void LoadUser(){
        /* Lesa fæl úr MyDocs? */
    }

    public String GetEmail(){ return email; }
    public void SetEmail( String email ){
        this.email = email;
    }

    public String GetGender(){ return gender; }
    public void SetGender( String gender ){
        this.gender = gender;
    }
    
    public int GetAge(){
        return age;
    }
    public void SetAge( int age ){
        this.age = age;
    }
    
    public List<String> GetInterests(){
        return interests;
    }
    public void SetInterests( String interest ){
        this.interests.add( interest );
    }
    
    public List<String> GetPastOrderNumbers(){
        return pastOrderNumbers;
    }
    public void SetPastOrderNumber( String order ){
        this.pastOrderNumbers.add( order );
    }
    
}