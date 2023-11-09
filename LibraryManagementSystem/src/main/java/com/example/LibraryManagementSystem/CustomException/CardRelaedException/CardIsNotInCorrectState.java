package com.example.LibraryManagementSystem.CustomException.CardRelaedException;

public class CardIsNotInCorrectState extends RuntimeException{
    public CardIsNotInCorrectState(String message) {
        super(message);
    }
}
