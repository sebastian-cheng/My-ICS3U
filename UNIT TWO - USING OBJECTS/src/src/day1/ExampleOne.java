package src.day1;
public class ExampleOne {
    public static void main(String[] args) {
        String superStudent = new String("Callum");
        String baseballPitcher = new String("Nolan Ryan");
        System.out.println(superStudent);
        System.out.println("Length of superStudent is " + superStudent.length());
        System.out.println("Substring of superStudent 2 - 4: " + superStudent.substring(2,4));

        System.out.println(baseballPitcher);
        System.out.println("Length of baseballPitcher is " + baseballPitcher.length());
        System.out.println("Substring of baseballPitcher 2 - 4: " + baseballPitcher.substring(2,4));
        /* int length
       System.out.println("Length of superStudent is " + superStudent.length());
        System.out.println("Length of baseballPitcher is " + baseballPitcher.length());
        */
        /*substring
        System.out.println("Substring of superStudent 2 - 4: " + superStudent.substring(2,4));
        System.out.println("Substring of baseballPitcher 2 - 4: " + baseballPitcher.substring(2,4));
        Middle of a string is length() / 2
        First half of a string is substring(0,length()/2)         
         */
        System.out.println(baseballPitcher.substring(0,baseballPitcher.length()/2));
        //second half is length()/2 and go to the end 
        System.out.println(baseballPitcher.substring(baseballPitcher.length()/2));
        //auto goes to the end

        //indexOf
        System.out.println("Where the first 'n' 'Nolan Ryan'?");
        System.out.println(baseballPitcher.indexOf("n"));
        
        System.out.println(baseballPitcher.substring(baseballPitcher.length() -1));
        }
        
    }

