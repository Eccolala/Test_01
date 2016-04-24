
public class Test {
    public static void main(String[] args) {
        String result = "放入3个土豆。";

        SpliteGenerate mSpliteGeneratenew = new SpliteGenerate(result);
        mSpliteGeneratenew.classification();
        mSpliteGeneratenew.displayStore();
    }
}
