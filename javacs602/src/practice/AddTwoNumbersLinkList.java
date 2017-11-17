package practice;

public class AddTwoNumbersLinkList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       return addNumbers(l1,l2, 0);
        
    }
    
    public static ListNode addNumbers(ListNode l1,ListNode l2, int carry)
    {
        
    	if(l1==null &&l2==null&&carry==0)
        {
          
        return null;   
        }
            int sum=carry;
            if(l1!=null)
            sum=sum+l1.val;
            if(l2!=null)
            sum=sum+l2.val;
            if(sum>9)
            {
                sum=sum%10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            ListNode returnNode= new ListNode(sum);
            returnNode.next=addNumbers(l1==null?null:l1.next,l2==null?null:l2.next,carry);
            return returnNode;
    }
    
}