package com.company;

public interface BirinchiInterface {
    /* interface bu umumiy naraslarni oldindan berib qo'yish hisoblanadi .Misol uchun uyning fundamentiga o'xshash */
    int min=6;
    void print();

    int print(int i);
}
  interface Ikkinchi extends BirinchiInterface{
    String bankName = "Asaka";

  }