import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by srinivaz on 2/24/18.
 */
public class MergeIntervals {
     static class Interval {
        int getStart(){
            return  this.start;
        }
        int getEnd(){
            return this.end;
        }
        int start,end;
        Interval(){
            start = 0;
            end = 0;
        }
        Interval(int s, int e) { start = s; end = e; }


         public int compareTo(Interval interval){
            return this.start < interval.start ? -1 : 1;
        }
    }

    public  List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        int i =1;
        intervals.sort(Comparator.comparing(Interval::getStart));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval:intervals){
            if(interval.start < end){
                end = Math.max(end,interval.end);
            }
            else {
                list.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        list.add(new Interval(start,end));
        return list;
    }

    public static void main(String[] args){
         MergeIntervals mergeIntervals = new MergeIntervals();
         List<Interval> list = new ArrayList<Interval>();
         list.add(new Interval(2,6));
         list.add(new Interval(1,3));
         list.add(new Interval(8,10));
         list.add(new Interval(15,18));
        System.out.println(mergeIntervals.merge(list));
    }

}
