import javax.swing.JButton;
import javax.swing.JOptionPane;

public interface ActionListener {

    JButton getSource();

    default void actionPerformed(Calculator calculator ) {
        // Code for number buttons
        for (int i = 0; i < 10; i++) {
            if (getSource() == calculator.numberButtons[i]) {
                calculator.textField.setText(calculator.textField.getText().concat(String.valueOf(i)));
            }
        }
    
        // Code for decimal button
        if (getSource() == calculator.decButton) {
            calculator.textField.setText(calculator.textField.getText() + ".");
        }
    
        // Code for addition button
        if (getSource() == calculator.addButton) {
            calculator.num1 = Double.parseDouble(calculator.textField.getText());
            calculator.operator = '+';
            calculator.textField.setText("");
        }
    
        // Code for subtraction button
        if (getSource() == calculator.SubButton) {
            calculator.num1 = Double.parseDouble(calculator.textField.getText());
            calculator.operator = '-';
            calculator.textField.setText("");
        }
    
        // Code for multiplication button
        if (getSource() == calculator.MulButton) {
            calculator.num1 = Double.parseDouble(calculator.textField.getText());
            calculator.operator = '*';
            calculator.textField.setText("");
        }
    
        // Code for division button
        if (getSource() == calculator.divButton) {
            calculator.num1 = Double.parseDouble(calculator.textField.getText());
            calculator.operator = '/';
            calculator.textField.setText("");
        }
    
        // Code for negative button
        if (getSource() == calculator.negButton) {
            double temp = Double.parseDouble(calculator.textField.getText());
            temp *= -1;
            calculator.textField.setText(String.valueOf(temp));
        }
    
        // Code for equal button
        if (getSource() == calculator.equButton) {
            calculator.num2 = Double.parseDouble(calculator.textField.getText());
    
            switch (calculator.operator) {
                case '+':
                    calculator.result = calculator.num1 + calculator.num2;
                    break;
                case '-':
                    calculator.result = calculator.num1 - calculator.num2;
                    break;
                case '*':
                    calculator.result = calculator.num1 * calculator.num2;
                    break;
                case '/':
                    if (calculator.num2 == 0) {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                        return;
                    }
                    calculator.result = calculator.num1 / calculator.num2;
                    break;
            }
            calculator.textField.setText(String.valueOf(calculator.result));
            calculator.num1 = calculator.result;
        }
    
        // Code for clear button
        if (getSource() == calculator.clrButton) {
            calculator.textField.setText("");
            calculator.num1 = 0;
            calculator.num2 = 0;
            calculator.result = 0;
            calculator.operator = '\u0000';
        }
    
        // Code for delete button
        if (getSource() == calculator.delButton) {
            String string = calculator.textField.getText();
            calculator.textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                calculator.textField.setText(calculator.textField.getText() + string.charAt(i));
            }
        }
        
    }

}
