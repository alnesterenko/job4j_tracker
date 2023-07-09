package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {

    private static double scoreOnePupil(Pupil onePupil) {
        double totalScores = 0D;
        for (Subject oneSubject : onePupil.subjects()) {
            totalScores += oneSubject.score();
        }
        return totalScores;
    }

    private static Label sortAndGetLast(List<Label> results) {
        Collections.sort(results, Comparator.naturalOrder());
        return results.get(results.size() - 1);
    }

    private static Map<String, Integer> crtMapSubjectsAndBales(List<Pupil> pupils) {
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        for (Pupil onePupil : pupils) {
            for (Subject oneSubject : onePupil.subjects()) {
                tempMap.put(oneSubject.name(), tempMap.getOrDefault(oneSubject.name(), 0) + oneSubject.score());
            }
        }
        return tempMap;
    }

    public static double averageScore(List<Pupil> pupils) {
        int countOfElements = 0;
        double totalScores = 0D;
        for (Pupil onePupil : pupils) {
            totalScores += scoreOnePupil(onePupil);
            countOfElements += onePupil.subjects().size();
        }
        return totalScores / countOfElements;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> results = new ArrayList<>(pupils.size());
        for (Pupil onePupil : pupils) {
            results.add(new Label(onePupil.name(), scoreOnePupil(onePupil) / onePupil.subjects().size()));
        }
        return results;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> resultList = new ArrayList<>();
        Map<String, Integer> tempMap = crtMapSubjectsAndBales(pupils);
        for (String key : tempMap.keySet()) {
            resultList.add(new Label(key, tempMap.get(key) / pupils.size()));
        }
        return resultList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> results = new ArrayList<>(pupils.size());
        for (Pupil onePupil : pupils) {
            results.add(new Label(onePupil.name(), scoreOnePupil(onePupil)));
        }
        return sortAndGetLast(results);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> resultList = new ArrayList<>();
        Map<String, Integer> tempMap = crtMapSubjectsAndBales(pupils);
        for (String key : tempMap.keySet()) {
            resultList.add(new Label(key, tempMap.get(key)));
        }
        return sortAndGetLast(resultList);
    }
}