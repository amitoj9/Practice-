package practice;

public class CArithmeticTree implements ArithmeticTree {

	protected Node root;

	static protected class Node {

		Object element;

		Node left, right;

	}

	// Constructor that creates an empty Tree.

	public CArithmeticTree() {

		root = null;

	}

	@Override

	public void buildTree(String expression) {

		this.expression = expression;

		root = new Node();

		root = buildExpressionTree(root);

	}

	// <expression> ::= <term> | <term> + <expression> | <term> - <expression>

	private Node buildExpressionTree(Node n) {
		Node leftTree = new Node();

		leftTree = buildTermTree(leftTree);

		readSymbol();

		if (symbol == '+' || symbol == '-') {

			pos++;

			n.left = leftTree;

			n.element = symbol;

			n.right = buildExpressionTree(new Node());

		} else {

			n = leftTree;

		}

		return n;
	}

	// <term> ::= <factor> | <factor> * <term> | <factor> / <term>

	private Node buildTermTree(Node n) {

		Node leftTree = new Node();

		leftTree = buildFactorTree(leftTree);

		readSymbol();

		if (symbol == '*' || symbol == '/') {

			pos++;

			n.left = leftTree;

			n.element = symbol;

			n.right = buildTermTree(new Node());

		} else {

			n = leftTree;

		}

		return n;

	}

	// <factor> ::= <constant> | (<expression>)

	private Node buildFactorTree(Node n) {

		readSymbol();

		if (symbol == '(') {

			pos++;

			n = buildExpressionTree(new Node());

			readSymbol();

			if (symbol == ')')

				pos++;


		} else {

			n.element = getConstant();

		}

		return n;

	}

	// Returns the next number in the expression. There are no restrictions on

	// the values for the number.

	private String getConstant() {

		StringBuilder sb = new StringBuilder();

		for (int i = pos; i < expression.length(); i++) {

			if (expression.substring(i, i + 1).matches("[0-9,.]")) {

				sb.append(expression.charAt(i));

				continue;

			}

			pos = i;

			return sb.toString();

		}

		pos = expression.length();

		return sb.toString();

	}

	// Finds the next symbol in the expression and assigns the value to

	// 'symbol'.

	private void readSymbol() {

		for (int i = pos; i < expression.length(); i++) {

			if (expression.substring(i, i + 1).matches("[0-9]"))

				continue;

			symbol = expression.charAt(i);

			return;

		}
		symbol = ' ';

	}

	@Override

	public double evalTree() {

		return traverseTree(root);

	}

	// Cycle through all nodes in the tree and evaluate the expression.

	private double traverseTree(Node n) {

		if (n != null) {

			if (n.left != null && n.right != null) {
				double right = traverseTree(n.right);
				double left = traverseTree(n.left);

				if (n.element.equals('+')) {

					return left + right;

				} else if (n.element.equals('-')) {

					return left - right;

				} else if (n.element.equals('*')) {

					return left * right;

				} else if (n.element.equals('/')) {

					return left / right;

				}

				System.out.println("Error - symbol not found.");

				return 0.0d;

			}

			try {

				return Double.parseDouble((String) n.element);

			}

			catch (NumberFormatException ex) {
				System.out.println("Error - double not found.");

				return 0.0d;

			}

		}

		System.out.println("Error - null node reached.");

		return 0.0d;

	}

	@Override

	public String toString() {

		return getTreeExpression(root);

	}

	// Traverse the tree and return the expression.

	private String getTreeExpression(Node n) {

		StringBuilder sb = new StringBuilder();

		if (n != null) {

			if (n.left != null) {
				sb.append("(");
				sb.append(getTreeExpression(n.left));

			}

			sb.append(n.element);

			if (n.right != null) {

				sb.append(getTreeExpression(n.right));

				sb.append(")");

			}

		}

		return sb.toString();

	}

	private String expression;

	private char symbol;

	private int pos = 0;

}