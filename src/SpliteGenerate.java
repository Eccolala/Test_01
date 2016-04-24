
public class SpliteGenerate {
    private String mResult;
    private String mOperate;
    private String mNumber;
    private String mCategory;

    public SpliteGenerate(String result) {
        this.mResult = result;
    }

    public void classification(){
        mOperate = mResult.substring(0,2);
        mNumber = mResult.substring(2,4);
        mCategory = mResult.substring(4,6);
    }

    public void displayStore(){
        System.out.println(mOperate);
        System.out.println(mNumber);
        System.out.println(mCategory);
    }
}
