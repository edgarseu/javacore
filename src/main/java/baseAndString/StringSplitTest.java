package baseAndString;

/**
 * @author caozy
 * @create 2018/12/21
 */
public class StringSplitTest {
    public static void main(String[] args) {
        String str = "te.st.(dhfjd).bbbb.（djfhj),cccc.(sdj.fdk）,dshjf（地方,很多将发挥）都很费劲的";
        char ch1 = '（';
        char ch2 = '(';
        char ch3 = '）';
        char ch4 = ')';

        String[] strings = str.split("\\(");
        String[] strings1 = str.split("\\（");
        str.indexOf("\\（");
        // 去除单词与 , 和 . 之间的空格
        String Str = "Hello , World .";
        String str1 = str.replace("(\\w*)","" );

        String pattern = "(\\w)(\\s+)([.,])";
        // $0 匹配 `(\w)(\s+)([.,])` 结果为 `o空格,` 和 `d空格.`
        // $1 匹配 `(\w)` 结果为 `o` 和 `d`
        // $2 匹配 `(\s+)` 结果为 `空格` 和 `空格`
        // $3 匹配 `([.,])` 结果为 `,` 和 `.`
        System.out.println(Str.replaceAll(pattern, "$1$3")); // Hello, World.

    }
}
