package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringOfEvenElements = new StringBuilder();
        int sizeOfEvenElements = evenElements.size();
        for (int i = 0; i < sizeOfEvenElements; i++) {
            if (i % 2 == 0) {
                stringOfEvenElements.append(evenElements.peekFirst());
            }
           evenElements.pollFirst();
        }
        return stringOfEvenElements.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringOfDescendingElements = new StringBuilder();
        int sizeOfDescendingElements = descendingElements.size();
        for (int i = 0; i < sizeOfDescendingElements; i++) {
                stringOfDescendingElements.append(descendingElements.pollLast());
        }
        return stringOfDescendingElements.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}