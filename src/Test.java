public class Test {

    public static String encrypt(String initialData){

        char[] trimmedData=  initialData.replaceAll(" ","").toCharArray();
       /*
       String[] val=initialData.split(" ");

       StringBuffer trimmedString= new StringBuffer();
        for (String s:val
             ) {
            trimmedString.append(s);
        }

        char[] trimmedData=trimmedString.toString().toCharArray();

        */

        int len=trimmedData.length;

        //check if len is perfectsqrt

        int lowLimit=0,upperLimit=0;

        Double limit =Math.sqrt(len);
        if(Math.pow(limit.intValue(),2)==len){
            //perfect square
            lowLimit=limit.intValue();
            upperLimit=limit.intValue();
        }else {
            //get presqrt
            for (int i = 1; Math.pow(i, 2) <= len; i++) {
                lowLimit = i;
            }
            for (int i = lowLimit; i <= Math.sqrt(len); i++) {
                if (Math.pow(i, 2) >= len) {
                    upperLimit = i;
                    break;
                }
            }
        }

        //creating matrix
        //lowlimit <=row<=column<=upperlimit
        //row * column <=len
        //min[row,column]

        int row=lowLimit+1,column=row;
        char a[][]= new char[row][column];
        int k=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column && k<len;j++,k++){
                a[i][j]=trimmedData[k];
            }
        }

        StringBuffer finalEncryptedVal=new StringBuffer();
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                finalEncryptedVal.append(a[j][i]);
            }
            finalEncryptedVal.append(" ");
        }




        return finalEncryptedVal.toString().trim();
    }

    public static void main(String[] args) {
      System.out.println( encrypt("Chill out"));
    }
}
