package programmers;

import java.util.*;

public class 해시_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(genres, plays)));
    }

    static class Solution {
        String[] genres;
        int[] plays;
        HashMap<String, Genre> check;
        String[] genres_set;

        public int[] solution(String[] genres, int[] plays) {
            this.genres = genres;
            this.plays = plays;
            classify();
            sort_genre();
            return show_result();
        }

        void classify() {
            check = new HashMap<String, Genre>(genres.length);
            for (int i = 0; i < genres.length; i++) {
                if (!check.containsKey(genres[i])) {
                    check.put(genres[i], new Genre());
                }
                check.get(genres[i]).add(plays[i], i);
            }
            genres_set = check.keySet().toArray(new String[check.size()]);
        }

        void sort_genre() {
            Arrays.sort(genres_set, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return check.get(o2).total_played - check.get(o1).total_played;
                }
            });
        }

        int[] show_result() {
            ArrayList<Integer> ret = new ArrayList<Integer>(check.keySet().size() * 2);
            for (String genre : genres_set) {
                ret.addAll(check.get(genre).popular);
            }
            return Arrays.stream(ret.toArray(new Integer[ret.size()])).mapToInt(Integer::intValue).toArray();
        }

        class Genre {
            int total_played = 0;
            int first = 0;
            int second = 0;
            ArrayList<Integer> popular = new ArrayList<Integer>(3);

            void add(int played, int song) {
                total_played += played;
                if (popular.size() == 0) {
                    first = played;
                    popular.add(song);
                } else if (popular.size() == 1) {
                    if (played < first) {
                        second = played;
                        popular.add(song);
                    } else {
                        second = first;
                        first = played;
                        popular.add(0, song);
                    }
                } else if (popular.size() == 2) {
                    if (played > first) {
                        second = first;
                        first = played;
                        popular.add(0, song);
                        popular.remove(popular.size() - 1);
                    } else if (played > second) {
                        second = played;
                        popular.set(1, song);
                    }
                }
            }
        }
    }
}

