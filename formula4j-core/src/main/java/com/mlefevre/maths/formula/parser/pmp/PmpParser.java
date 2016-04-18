package com.mlefevre.maths.formula.parser.pmp;

import com.mlefevre.maths.formula.Formula;
import com.mlefevre.maths.formula.parser.Parser;
import com.mlefevre.maths.formula.parser.ParsingException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PmpParser implements Parser {

    private static PmpParser instance;

    private Groups groups;
    private Formula formula;

    private PmpParser() {
        groups = new Groups();
        formula = new Formula();
    }

    public synchronized static PmpParser getInstance() {
        if(null == instance) {
            instance = new PmpParser();
        }
        return instance;
    }


    public Formula parse(String input) throws ParsingException {
        if(null == input) {
            return formula;
        }

        char[] parts = input.toCharArray();

        initGroups(parts);
        parseGroups(parts);

        return formula;
    }



    private void initGroups(char[] input) {
        int index = 0;
        for(char part : input) {
            if('{' == part) {
                groups.add(new Group(index));
            } else if('}' == part) {
                if(groups.isEmpty()) {
                    continue;
                }
                Group group = groups.getLastOpen();
                group.setEnd(index);
            }
            index++;
        }
    }


    private void parseGroups(char[] parts) {
        while(groups.hasNext()) {
            Group current = groups.next();
            if(current.isParent()) {

            }
        }
    }









    private class Groups {

        private int currentIndex = 0;
        private List<Group> groups = new ArrayList<>();

        private Map<Integer, Group> startSearch = new HashMap<>();
        private Map<Integer, Group> endSearch = new HashMap<>();


        public boolean hasNext() {
            return currentIndex < groups.size();
        }

        public Group next() {
            Group next = groups.get(currentIndex);
            currentIndex++;

            return next;
        }


        public boolean isEmpty() {
            return groups.isEmpty();
        }

        public void add(Group group) {
            if(!isEmpty()) {
                Group last = getLast();
                if(null != last) {
                    if(last.isOpen()) {
                        group.setChild(true);
                        last.setParent(true);
                    } else {
                        group.setAdjacent(last.getEnd().equals(group.getStart() - 1));
                    }
                }
            }
            groups.add(group);
        }

        public Group getLastOpen() {
            if(groups.isEmpty()) {
                return null;
            }
            Group lastOpen = null;
            for(int i = groups.size() - 1; i >= 0; i--) {
                Group group = groups.get(i);
                if(group.isOpen()) {
                    lastOpen = group;
                    break;
                }
            }
            return lastOpen;
        }

        private Group getLast() {
            if(isEmpty()) {
                return null;
            }
            return groups.get(groups.size() - 1);
        }

        public Group getByStartIndex(Integer index) {
            Group match = null;

            Group cache = startSearch.get(index);
            if(null != cache) {
                return cache;
            }

            for(Group group : groups) {
                startSearch.put(group.getStart(), group);
                if(group.getStart().equals(index)) {
                    match = group;
                    break;
                }
            }
            return match;
        }

        public Group getByEndIndex(Integer index) {
            Group match = null;

            Group cache = endSearch.get(index);
            if(null != cache) {
                return cache;
            }

            for(Group group : groups) {
                endSearch.put(group.getEnd(), group);
                if(group.getEnd().equals(index)) {
                    match = group;
                    break;
                }
            }
            return match;
        }

    }

    private class Group {

        private Integer start = null;
        private Integer end = null;
        private boolean adjacent = false;
        private boolean child = false;
        private boolean parent = false;

        public Group(int start) {
            this.start = start;
        }

        public Integer getStart() {
            return start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public void setAdjacent(boolean adjacent) {
            this.adjacent = adjacent;
        }

        public boolean isAdjacent() {
            return adjacent;
        }

        public boolean isChild() {
            return child;
        }

        public void setChild(boolean child) {
            this.child = child;
        }

        public boolean isParent() {
            return parent;
        }

        public void setParent(boolean parent) {
            this.parent = parent;
        }

        public boolean isOpen() {
            return null == end;
        }

    }

}
