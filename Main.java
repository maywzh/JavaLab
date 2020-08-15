import java.util.*;
import java.util.stream.Collectors;

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);
            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(",")).map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }

}

public class Main {

    private static int maxlength = 0;

    public static void dfs(WorkflowNode node, int length) {
        if (node == null || node.nextNodes == null || node.nextNodes.size() <= 0) {
            return;
        }
        if (node != null && node.nextNodes != null && node.nextNodes.size() > 0) {
            for (WorkflowNode n : node.nextNodes) {
                maxlength = maxlength < length + n.timeoutMillis ? length + n.timeoutMillis : maxlength;
                dfs(n, length + n.timeoutMillis);
            }
        }
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        WorkflowNode node = new WorkflowNode("", 0, null);
        while (cin.hasNext()) {
            node = WorkflowNode.load(cin.next());
        }
        if (node != null && node.nextNodes.size() > 0) {
            dfs(node, 0);
            System.out.println(maxlength);
        } else {
            System.out.println(0);
        }

    }

}