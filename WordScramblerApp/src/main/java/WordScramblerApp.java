import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordScramblerApp extends JFrame {
    private JTextArea inputArea;
    private JButton scrambleButton;

    public WordScramblerApp() {
        // Инициализация на компонентите
        inputArea = new JTextArea();
        inputArea.setWrapStyleWord(true);
        inputArea.setLineWrap(true);

        // Задаване на отстъп за текста в текстовото поле (тук задаваме отстъп от 10 пиксела от ляво и 5 пиксела отгоре)
        inputArea.setMargin(new Insets(5, 10, 5, 10));

        JScrollPane scrollPane = new JScrollPane(inputArea);

        scrambleButton = new JButton("Разбъркай думите");
        scrambleButton.setPreferredSize(new Dimension(150, 40));

        // Основен панел за центриране на елементите
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Добавяне на панели за ляво, дясно, горно и долно пространство
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.GREEN);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.GREEN);
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.GREEN);
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.GREEN);

        // Задаване на предпочитана ширина за панелите
        bottomPanel.setPreferredSize(new Dimension(0, 30));
        topPanel.setPreferredSize(new Dimension(0, 30));
        leftPanel.setPreferredSize(new Dimension(30, 0));
        rightPanel.setPreferredSize(new Dimension(30, 0));

        // Добавяне на панелите с цветно пространство в основния панел
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(rightPanel, BorderLayout.EAST);
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Добавяне на текстовата зона в централната част на панела
        panel.add(scrollPane, BorderLayout.CENTER);

        // Поставяме панела в центъра на главния прозорец
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        // Добавяне на панела с бутона в долната част
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(scrambleButton);

        // Поставяме панела с бутона в долната част на прозореца
        add(buttonPanel, BorderLayout.SOUTH);

        // Добавяне на слушател на бутона с ламбда израз
        scrambleButton.addActionListener(e -> scrambleWords());

        // Основни настройки на прозореца
        setTitle("Word Scrambler");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Метод за разбъркване на думите
    private void scrambleWords() {
        String inputText = inputArea.getText().trim(); // Взимаме текста от inputArea
        if (!inputText.isEmpty()) {
            // Разделяме текста на отделни думи
            String[] words = inputText.split("\\s+");
            List<String> wordList = Arrays.asList(words);
            Collections.shuffle(wordList); // Разбъркваме списъка с думи

            // Събиране на новия разбъркан текст
            StringBuilder scrambledText = new StringBuilder();
            for (String word : wordList) {
                scrambledText.append(word).append("\n"); // Добавяме всяка дума на нов ред
            }

            inputArea.setText(scrambledText.toString()); // Поставяме разбъркания текст в inputArea
        }
    }
}
