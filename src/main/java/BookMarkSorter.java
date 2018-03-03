import java.util.*;

/**
 * Created by srinivaz on 3/2/18.
 */
public class BookMarkSorter {
    static public class BookMark {
        double time;
         double getTime(){
            return time;
        }
        BookMark(double time){
             this.time = time;
        }

    }

    static public class Chapter  {
        List<BookMark> bookMarks = new ArrayList<>();
        void setStartTime(double startTime) {
            this.startTime = startTime;
        }

            double getEndTime() {
            return endTime;
        }

        void setEndTime(double endTime) {
            this.endTime = endTime;
        }

        Chapter(double startTime,double endTime){
            this.startTime =startTime;
            this.endTime = endTime;
        }

        double startTime;
        double endTime;

         double getStartTime() {return  startTime;}

    }

    public static void sortBookMarks(List<BookMark> bookMarks,List<Chapter> chapters ){
        bookMarks.sort(Comparator.comparing(BookMark::getTime));
        chapters.sort(Comparator.comparing(Chapter::getStartTime));

       Chapter currentChapter = null;
        Iterator<Chapter> iterator = chapters.listIterator();
        if(iterator.hasNext()){
            currentChapter = iterator.next();
        }
        for(BookMark bookMark : bookMarks){
            if(currentChapter != null && currentChapter.getStartTime() <= bookMark.getTime() && bookMark.getTime() <= currentChapter.getEndTime()) {
                currentChapter.bookMarks.add(bookMark);
            }
            else if(iterator.hasNext()) currentChapter =  iterator.next();
        }
        System.out.println(chapters);
    }

    public static  void main(String args[]){
        List<Double> bkmks = Arrays.asList(1.3,4.6,7.9,6.3,1.6,1.9,2.1,3.5,12.3,14.9,98.0,1.0,0.9,133.0);
        Chapter chapter1 = new Chapter(0.0,2.3);
        Chapter chapter2 = new Chapter(2.4,5.0);
        Chapter chapter3 = new Chapter(5.1,11.0);
        Chapter chapter4 = new Chapter(11.1,50.0);
        Chapter chapter5 = new Chapter(50.1,111.0);
        Chapter chapter6 = new Chapter(111.1,145.0);
        List<BookMark> bookMarks = new ArrayList<>();
        for(double bk : bkmks){
            bookMarks.add(new BookMark(bk));
        }
        List<Chapter> chapters = new ArrayList<>();
        chapters.add(chapter1);
        chapters.add(chapter2);
        chapters.add(chapter3);
        chapters.add(chapter4);
        chapters.add(chapter5);
        chapters.add(chapter6);
        sortBookMarks(bookMarks,chapters);
    }
}
