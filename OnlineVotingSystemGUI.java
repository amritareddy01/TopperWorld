import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OnlineVotingSystemGUI extends JFrame
{
    private List<Candidate> candidates;
    private List<Voter> voters;
    private JTextArea displayArea;
    public OnlineVotingSystemGUI()
{
        candidates = new ArrayList<>();
        voters = new ArrayList<>();
        candidates.add(new Candidate("Candidate A", "Party A"));
        candidates.add(new Candidate("Candidate B", "Party B"));
        candidates.add(new Candidate("Candidate C", "Party C"));
        setTitle("Online Voting System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2));
        topPanel.add(new JLabel("Name: "));
        JTextField nameField = new JTextField();
        topPanel.add(nameField);
        topPanel.add(new JLabel("Phone: "));
        JTextField phoneField = new JTextField();
        topPanel.add(phoneField);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        displayArea = new JTextArea();
        centerPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, candidates.size()));
        for (Candidate candidate : candidates)
{
            JButton voteButton = new JButton(candidate.getName());
            voteButton.addActionListener(new ActionListener()
{
                @Override
                public void actionPerformed(ActionEvent e)
{
                    String name = nameField.getText();
                    String phone = phoneField.getText();
                    Voter voter = new Voter(name, phone);
                    castVote(voter, candidate);
                }
            });
            bottomPanel.add(voteButton);
        }
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(mainPanel);
        setVisible(true);
    }
    private void castVote(Voter voter, Candidate candidate)
{
        if (voters.contains(voter))
{
            displayMessage("You have already voted.\n");
        }
else
{
            voters.add(voter);
            displayMessage("Your vote for " + candidate.getName() + " (" + candidate.getParty() + ") has been cast.\n");
        }
    }

    private void displayMessage(String message)
{
        displayArea.append(message);
    }

    public static void main(String[] args)
{
        SwingUtilities.invokeLater(new Runnable()
{
            @Override
            public void run()
{
                new OnlineVotingSystemGUI();
            }
        });
    }
}

class Candidate
{
    private String name;
    private String party;
    public Candidate(String name, String party)
{
        this.name = name;
        this.party = party;
    }
    public String getName()
{
        return name;
    }
    public String getParty()
{
        return party;
    }
}

class Voter
{
    private String name;
    private String phone;
    public Voter(String name, String phone)
{
        this.name = name;
        this.phone = phone;
    }

    public String getName()
{
        return name;
    }

    public String getPhone()
{
        return phone;
    }
}
