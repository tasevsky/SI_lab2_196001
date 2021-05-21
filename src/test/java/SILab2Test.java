import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {

    private final SILab2 lab = new SILab2();
    private List<Time> list = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();

    @Test
    public void MultipleCondition() {
        List<Time> list1 = new ArrayList<>();
        list1.add(new Time(-1,45,45));
        List<Time> list2 = new ArrayList<>();
        list2.add(new Time(25,14,14));
        List<Time> list3 = new ArrayList<>();
        list3.add(new Time(4,5,6));
        List<Time> list4 = new ArrayList<>();
        list4.add(new Time(22,-1,15));
        List<Time> list5 = new ArrayList<>();
        list5.add(new Time(22,61,15));
        List<Time> list6 = new ArrayList<>();
        list6.add(new Time(22,15,-1));
        List<Time> list7 = new ArrayList<>();
        list7.add(new Time(22,15,61));
        List<Time> list8 = new ArrayList<>();
        list8.add(new Time(24,0,0));
        List<Time> list9 = new ArrayList<>();
        list9.add(new Time(24,0,1));
        List<Time> list10 = new ArrayList<>();
        list10.add(new Time(24,13,13));

        RuntimeException exception = null;

        try{
            lab.function(list1);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The hours are smaller than the minimum", exception.getMessage());

        try{
            lab.function(list2);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The hours are greater than the maximum", exception.getMessage());

        result.add(14706);
        assertEquals(result, lab.function(list3));

        try{
            lab.function(list4);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            lab.function(list5);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            lab.function(list6);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        try{
            lab.function(list7);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        result.remove(0);
        result.add(86400);
        assertEquals(result, lab.function(list8));

        try{
            lab.function(list9);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());

        try{
            lab.function(list10);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());
    }

    @Test
    public void EveryBranch() {
        List<Time> list1 = new ArrayList<>();
        List<Time> list2 = new ArrayList<>();
        list2.add(new Time(-1,45,45));
        List<Time> list3 = new ArrayList<>();
        list3.add(new Time(25,45,45));
        List<Time> list4 = new ArrayList<>();
        list4.add(new Time(22,-2,2));
        List<Time> list5 = new ArrayList<>();
        list5.add(new Time(22,2,-2));
        List<Time> list6 = new ArrayList<>();
        list6.add(new Time(22,2,2));
        List<Time> list7 = new ArrayList<>();
        list7.add(new Time(24,0,0));
        List<Time> list8 = new ArrayList<>();
        list8.add(new Time(24,2,2));


        result = lab.function(list1);
        assertTrue(result.isEmpty());

        RuntimeException exception = null;

        try{
            lab.function(list2);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The hours are smaller than the minimum", exception.getMessage());

        try{
            lab.function(list3);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The hours are greater than the maximum", exception.getMessage());

        try{
            lab.function(list4);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            lab.function(list5);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        result.add(79322);
        assertEquals(result, lab.function(list6));

        result.remove(0);
        result.add(86400);
        assertEquals(result, lab.function(list7));

        try{
            lab.function(list8);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());
    }

}
