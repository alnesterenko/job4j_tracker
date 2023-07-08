package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int countOfElements = 0;
        double totalScores = 0D;
        for (Pupil onePupil : pupils) {
            for (Subject oneSubject : onePupil.subjects()) {
                totalScores += oneSubject.score();
                countOfElements++;
            }
        }
        return totalScores / countOfElements;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> results = new ArrayList<>(pupils.size());
        for (Pupil onePupil : pupils) {
            double totalScores = 0D;
            for (Subject oneSubject : onePupil.subjects()) {
                totalScores += oneSubject.score();
            }
            results.add(new Label(onePupil.name(), totalScores / onePupil.subjects().size()));
        }
        return results;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> resultList = new ArrayList<>();
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        for (Pupil onePupil : pupils) {
            for (Subject oneSubject : onePupil.subjects()) {
                tempMap.put(oneSubject.name(),
                        tempMap.get(oneSubject.name()) == null ? oneSubject.score()
                                : tempMap.get(oneSubject.name()) + oneSubject.score());
            }
        }
        for (String key : tempMap.keySet()) {
            resultList.add(new Label(key, tempMap.get(key) / pupils.size()));
        }
        return resultList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> results = new ArrayList<>(pupils.size());
        for (Pupil onePupil : pupils) {
            double totalScores = 0D;
            for (Subject oneSubject : onePupil.subjects()) {
                totalScores += oneSubject.score();
            }
            results.add(new Label(onePupil.name(), totalScores));
        }
        Collections.sort(results, Comparator.naturalOrder());
        return results.get(results.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> resultList = new ArrayList<>();
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        for (Pupil onePupil : pupils) {
            for (Subject oneSubject : onePupil.subjects()) {
                tempMap.put(oneSubject.name(),
                        tempMap.get(oneSubject.name()) == null ? oneSubject.score()
                                : tempMap.get(oneSubject.name()) + oneSubject.score());
            }
        }
        for (String key : tempMap.keySet()) {
            resultList.add(new Label(key, tempMap.get(key)));
        }
        Collections.sort(resultList, Comparator.naturalOrder());
        return resultList.get(resultList.size() - 1);
    }
}