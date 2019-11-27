package com.example.calculatorexam;

public class Calculadora {
    private double memory;
    public Calculadora(){
        this.memory=0;
    }

    public double getMemory() {
        return memory;
    }

    public double setMemory(double memory) {
        this.memory = memory;
        return memory;
    }

    public double sum(double num1, double num2) throws IllegalArgumentException{
        return(num1+num2);
    }
    public double sub(double num1, double num2)throws IllegalArgumentException{
        return(num1-num2);
    }
    public double mult(double num1, double num2)throws IllegalArgumentException{
        return(num1*num2);
    }
    public double div(double num1, double num2)throws IllegalArgumentException{
        return(num1/num2);
    }
    public double memorySum(double n){
        memory+=n;
        return memory;
    }
    public double memorySub(double n){
        memory-=n;
        return memory;
    }

}
