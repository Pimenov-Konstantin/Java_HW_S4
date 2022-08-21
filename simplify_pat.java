import java.util.ArrayDeque;
import java.util.Deque;

public class simplify_pat {

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] tempArr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String item : tempArr) {
            if (item.equals("..") && !stack.isEmpty()) {
                stack.pollLast(); //удаляем из стека
            } else if (!(item.equals("")) && (!item.equals(".")) && (!item.equals(".."))) {
                stack.add(item);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder newPath = new StringBuilder();
        while (!stack.isEmpty()) {
            newPath.insert(0, ("/" + stack.pollLast()));
        }
        return newPath.toString();
    }
}