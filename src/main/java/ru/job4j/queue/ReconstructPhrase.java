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
        StringBuilder stringOfEvenElems = new StringBuilder();
        int sizeOfSet = evenElements.size();
        for (int i = 0; i < sizeOfSet; i++) {
            if (i % 2 == 0) {
                stringOfEvenElems.append(evenElements.peekFirst());
            }
           evenElements.pollFirst();
        }
        return stringOfEvenElems.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringOfDescendElems = new StringBuilder();
        int sizeOfSet = descendingElements.size();
        for (int i = 0; i < sizeOfSet; i++) {
                stringOfDescendElems.append(descendingElements.pollLast());
        }
        return stringOfDescendElems.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}