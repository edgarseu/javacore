package algorithm.str;

/**
 * @author caozy
 * @date 2019/9/9 10:10
 */
public class StrAl {
    public static void main(String[] args) {

    }

    private void solve(char[] str, char[] res, int size, int cur){
        if(size - 1 == cur){
            for(int i = 0; i < size; i++){
                System.out.print(str[i]);
            }
        } else {
            str[cur] = str[size];
        }
    }
}



class Singleton {

    private static class SingletonWrapper {
        static Singleton instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonWrapper.instance;
    }
}