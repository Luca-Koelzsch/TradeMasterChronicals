package tmc.gui;

import java.io.IOException;
import javax.swing.JPanel;
import tmc.core.Game;
import tmc.core.exceptions.GoodsException;
import tmc.core.exceptions.MoneyException;


public class frame extends javax.swing.JFrame implements Runnable {

    Game game;
    Thread gameThread;
    char dollar = '$';

    public frame() {
        initComponents();
        settings();
        
        //Game ID in der GUI erstmal hard gecoded, man kann also erstmal nur ein Spiel starten und dann speichern und laden
        game = new Game(100);
        try {
            game.load();
        } catch (Exception e) {
        }
        
        gameThread = new Thread(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        startGameButton = new javax.swing.JButton();
        loadGameButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        startGamePanel = new javax.swing.JPanel();
        companyNameField = new javax.swing.JTextField();
        enterameLabel = new javax.swing.JLabel();
        okayButton = new javax.swing.JButton();
        enterameLabel1 = new javax.swing.JLabel();
        enterameLabel2 = new javax.swing.JLabel();
        loadGamePanel = new javax.swing.JPanel();
        gamePanel = new javax.swing.JPanel();
        monneyLabel = new javax.swing.JLabel();
        globalMarketButton = new javax.swing.JButton();
        companyNameLabel = new javax.swing.JLabel();
        npcMarketButton = new javax.swing.JButton();
        inventoryButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        levelLabel = new javax.swing.JLabel();
        globalMarketPanel = new javax.swing.JPanel();
        africaButton = new javax.swing.JButton();
        aisanButton = new javax.swing.JButton();
        australiaButton = new javax.swing.JButton();
        europeButton = new javax.swing.JButton();
        nothAmericaButton = new javax.swing.JButton();
        russiaButton = new javax.swing.JButton();
        southAmericaButton = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        npcMarketPanel = new javax.swing.JPanel();
        inventoryPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cementCountLabel = new javax.swing.JLabel();
        ceramicCountLabel = new javax.swing.JLabel();
        woodCountLabel = new javax.swing.JLabel();
        chipsCountLabel = new javax.swing.JLabel();
        copperCountLabel = new javax.swing.JLabel();
        goldCountLabel = new javax.swing.JLabel();
        steelCountLabel = new javax.swing.JLabel();
        plasticCountLabel = new javax.swing.JLabel();
        oilCountLabel = new javax.swing.JLabel();
        glassCountLabel = new javax.swing.JLabel();
        backButton2 = new javax.swing.JButton();
        africaPanel = new javax.swing.JPanel();
        backButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        africaGoldPriceLabel = new javax.swing.JLabel();
        africaOilPriceLabel = new javax.swing.JLabel();
        africaCopperPriceLabel = new javax.swing.JLabel();
        buyAfricaGoldButton = new javax.swing.JButton();
        sellAfricaGoldButton = new javax.swing.JButton();
        sellAfricaOilButton1 = new javax.swing.JButton();
        buyAfricaOilButton1 = new javax.swing.JButton();
        sellAfricaCopperButton = new javax.swing.JButton();
        buyAfricaCopperButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        startGameButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        startGameButton.setText("start");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        loadGameButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        loadGameButton.setText("load");
        loadGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        exitButton.setText("exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(421, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(startGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(loadGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        mainPanel.add(menuPanel, "card2");

        companyNameField.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        companyNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyNameFieldActionPerformed(evt);
            }
        });

        enterameLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        enterameLabel.setText("Enter your company`s name");

        okayButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        okayButton.setText("okay");
        okayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okayButtonActionPerformed(evt);
            }
        });

        enterameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        enterameLabel1.setText("Sehr geehrter Herr Schmietendorf, die GUI ist aktuell nur zu Testzwecken implementiert. In der GUI funktioniert nur das Inventar und das Kaufen in Africa. Wenn Sie alle anderen Funktionen testen möchten, ");

        enterameLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        enterameLabel2.setText("starten Sie das Spiel über die Main-Methode und passen Sie in der Game-Klasse die run() Methode mit Code zum Manipulieren des Spiels an. Wir haben da was für Sie vorbereitet. LG das Team");

        javax.swing.GroupLayout startGamePanelLayout = new javax.swing.GroupLayout(startGamePanel);
        startGamePanel.setLayout(startGamePanelLayout);
        startGamePanelLayout.setHorizontalGroup(
            startGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startGamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(startGamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(startGamePanelLayout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addGroup(startGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(companyNameField)
                    .addComponent(enterameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startGamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        startGamePanelLayout.setVerticalGroup(
            startGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startGamePanelLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(enterameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(enterameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterameLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(okayButton)
                .addGap(33, 33, 33))
        );

        mainPanel.add(startGamePanel, "card3");

        javax.swing.GroupLayout loadGamePanelLayout = new javax.swing.GroupLayout(loadGamePanel);
        loadGamePanel.setLayout(loadGamePanelLayout);
        loadGamePanelLayout.setHorizontalGroup(
            loadGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        loadGamePanelLayout.setVerticalGroup(
            loadGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        mainPanel.add(loadGamePanel, "card5");

        monneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        monneyLabel.setText("0$");

        globalMarketButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        globalMarketButton.setText("global market");
        globalMarketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                globalMarketButtonActionPerformed(evt);
            }
        });

        companyNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        companyNameLabel.setText("Kölzsch");

        npcMarketButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        npcMarketButton.setText("NPC market");
        npcMarketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npcMarketButtonActionPerformed(evt);
            }
        });

        inventoryButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        inventoryButton.setText("inventory");
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        saveButton.setText("save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        levelLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        levelLabel.setText("Level: 1");

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(companyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(monneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(globalMarketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addComponent(npcMarketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(inventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                        .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(globalMarketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(npcMarketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainPanel.add(gamePanel, "card4");

        africaButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        africaButton.setText("Africa");
        africaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                africaButtonActionPerformed(evt);
            }
        });

        aisanButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        aisanButton.setText("Asian");
        aisanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aisanButtonActionPerformed(evt);
            }
        });

        australiaButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        australiaButton.setText("Australia");
        australiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                australiaButtonActionPerformed(evt);
            }
        });

        europeButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        europeButton.setText("Europe");
        europeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                europeButtonActionPerformed(evt);
            }
        });

        nothAmericaButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        nothAmericaButton.setText("North America");
        nothAmericaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nothAmericaButtonActionPerformed(evt);
            }
        });

        russiaButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        russiaButton.setText("Russia");
        russiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                russiaButtonActionPerformed(evt);
            }
        });

        southAmericaButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        southAmericaButton.setText("South America");
        southAmericaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                southAmericaButtonActionPerformed(evt);
            }
        });

        backButton1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        backButton1.setText("back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout globalMarketPanelLayout = new javax.swing.GroupLayout(globalMarketPanel);
        globalMarketPanel.setLayout(globalMarketPanelLayout);
        globalMarketPanelLayout.setHorizontalGroup(
            globalMarketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(globalMarketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(africaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aisanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(australiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(europeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(globalMarketPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(nothAmericaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(russiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(southAmericaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(globalMarketPanelLayout.createSequentialGroup()
                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        globalMarketPanelLayout.setVerticalGroup(
            globalMarketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(globalMarketPanelLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(globalMarketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(africaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aisanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(australiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(europeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(globalMarketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nothAmericaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(russiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(southAmericaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(globalMarketPanel, "card6");

        javax.swing.GroupLayout npcMarketPanelLayout = new javax.swing.GroupLayout(npcMarketPanel);
        npcMarketPanel.setLayout(npcMarketPanelLayout);
        npcMarketPanelLayout.setHorizontalGroup(
            npcMarketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        npcMarketPanelLayout.setVerticalGroup(
            npcMarketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        mainPanel.add(npcMarketPanel, "card7");

        inventoryPanel.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\cement.png")); // NOI18N
        inventoryPanel.add(jLabel2);
        jLabel2.setBounds(30, 10, 200, 146);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\chips.png")); // NOI18N
        inventoryPanel.add(jLabel3);
        jLabel3.setBounds(730, 10, 200, 171);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\ceramic.png")); // NOI18N
        inventoryPanel.add(jLabel4);
        jLabel4.setBounds(280, 20, 200, 156);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\wood.png")); // NOI18N
        inventoryPanel.add(jLabel5);
        jLabel5.setBounds(500, 20, 200, 150);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\glass.png")); // NOI18N
        inventoryPanel.add(jLabel6);
        jLabel6.setBounds(20, 280, 200, 320);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\cupper.png")); // NOI18N
        inventoryPanel.add(jLabel7);
        jLabel7.setBounds(970, 20, 200, 141);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\gold.png")); // NOI18N
        inventoryPanel.add(jLabel8);
        jLabel8.setBounds(990, 390, 200, 141);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\oil.png")); // NOI18N
        inventoryPanel.add(jLabel9);
        jLabel9.setBounds(320, 300, 200, 260);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\plastic.png")); // NOI18N
        inventoryPanel.add(jLabel10);
        jLabel10.setBounds(560, 310, 200, 260);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\steel.png")); // NOI18N
        inventoryPanel.add(jLabel11);
        jLabel11.setBounds(780, 310, 200, 260);

        cementCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cementCountLabel.setText("1000");
        inventoryPanel.add(cementCountLabel);
        cementCountLabel.setBounds(50, 180, 110, 70);

        ceramicCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ceramicCountLabel.setText("1000");
        inventoryPanel.add(ceramicCountLabel);
        ceramicCountLabel.setBounds(310, 180, 110, 70);

        woodCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        woodCountLabel.setText("1000");
        inventoryPanel.add(woodCountLabel);
        woodCountLabel.setBounds(550, 180, 110, 70);

        chipsCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        chipsCountLabel.setText("1000");
        inventoryPanel.add(chipsCountLabel);
        chipsCountLabel.setBounds(790, 190, 110, 70);

        copperCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        copperCountLabel.setText("1000");
        inventoryPanel.add(copperCountLabel);
        copperCountLabel.setBounds(1020, 190, 110, 70);

        goldCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        goldCountLabel.setText("1000");
        inventoryPanel.add(goldCountLabel);
        goldCountLabel.setBounds(1030, 560, 110, 70);

        steelCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        steelCountLabel.setText("1000");
        inventoryPanel.add(steelCountLabel);
        steelCountLabel.setBounds(830, 570, 110, 70);

        plasticCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        plasticCountLabel.setText("1000");
        inventoryPanel.add(plasticCountLabel);
        plasticCountLabel.setBounds(610, 580, 110, 70);

        oilCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        oilCountLabel.setText("1000");
        inventoryPanel.add(oilCountLabel);
        oilCountLabel.setBounds(370, 590, 110, 70);

        glassCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        glassCountLabel.setText("1000");
        inventoryPanel.add(glassCountLabel);
        glassCountLabel.setBounds(50, 610, 110, 70);

        backButton2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        backButton2.setText("back");
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });
        inventoryPanel.add(backButton2);
        backButton2.setBounds(10, 710, 170, 54);

        mainPanel.add(inventoryPanel, "card8");

        africaPanel.setLayout(null);

        backButton3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        backButton3.setText("back");
        backButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton3ActionPerformed(evt);
            }
        });
        africaPanel.add(backButton3);
        backButton3.setBounds(10, 700, 170, 54);

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\oil.png")); // NOI18N
        africaPanel.add(jLabel12);
        jLabel12.setBounds(100, 200, 200, 260);

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\cupper.png")); // NOI18N
        africaPanel.add(jLabel13);
        jLabel13.setBounds(500, 280, 200, 141);

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luca Kölzsch\\Documents\\NetBeansProjects\\TradeMasterChronicals\\src\\images\\goods\\gold.png")); // NOI18N
        africaPanel.add(jLabel14);
        jLabel14.setBounds(870, 280, 200, 141);

        africaGoldPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        africaGoldPriceLabel.setText("1000");
        africaPanel.add(africaGoldPriceLabel);
        africaGoldPriceLabel.setBounds(930, 430, 110, 70);

        africaOilPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        africaOilPriceLabel.setText("1000");
        africaPanel.add(africaOilPriceLabel);
        africaOilPriceLabel.setBounds(150, 470, 110, 70);

        africaCopperPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        africaCopperPriceLabel.setText("1000");
        africaPanel.add(africaCopperPriceLabel);
        africaCopperPriceLabel.setBounds(540, 450, 110, 70);

        buyAfricaGoldButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        buyAfricaGoldButton.setText("buy");
        buyAfricaGoldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyAfricaGoldButtonActionPerformed(evt);
            }
        });
        africaPanel.add(buyAfricaGoldButton);
        buyAfricaGoldButton.setBounds(850, 510, 100, 54);

        sellAfricaGoldButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        sellAfricaGoldButton.setText("sell");
        sellAfricaGoldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellAfricaGoldButtonActionPerformed(evt);
            }
        });
        africaPanel.add(sellAfricaGoldButton);
        sellAfricaGoldButton.setBounds(960, 510, 100, 54);

        sellAfricaOilButton1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        sellAfricaOilButton1.setText("sell");
        sellAfricaOilButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellAfricaOilButton1ActionPerformed(evt);
            }
        });
        africaPanel.add(sellAfricaOilButton1);
        sellAfricaOilButton1.setBounds(170, 530, 100, 54);

        buyAfricaOilButton1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        buyAfricaOilButton1.setText("buy");
        buyAfricaOilButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyAfricaOilButton1ActionPerformed(evt);
            }
        });
        africaPanel.add(buyAfricaOilButton1);
        buyAfricaOilButton1.setBounds(50, 530, 100, 54);

        sellAfricaCopperButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        sellAfricaCopperButton.setText("sell");
        sellAfricaCopperButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellAfricaCopperButtonActionPerformed(evt);
            }
        });
        africaPanel.add(sellAfricaCopperButton);
        sellAfricaCopperButton.setBounds(570, 510, 100, 54);

        buyAfricaCopperButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        buyAfricaCopperButton.setText("buy");
        buyAfricaCopperButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyAfricaCopperButtonActionPerformed(evt);
            }
        });
        africaPanel.add(buyAfricaCopperButton);
        buyAfricaCopperButton.setBounds(450, 510, 100, 54);

        mainPanel.add(africaPanel, "card9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        changePnel(startGamePanel);
    }//GEN-LAST:event_startGameButtonActionPerformed

    private void loadGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameButtonActionPerformed
        changePnel(loadGamePanel);
    }//GEN-LAST:event_loadGameButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void companyNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyNameFieldActionPerformed

    private void okayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okayButtonActionPerformed
        changePnel(gamePanel);
        start();
    }//GEN-LAST:event_okayButtonActionPerformed

    private void globalMarketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalMarketButtonActionPerformed
        changePnel(globalMarketPanel);
    }//GEN-LAST:event_globalMarketButtonActionPerformed

    private void npcMarketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npcMarketButtonActionPerformed
        changePnel(npcMarketPanel);
    }//GEN-LAST:event_npcMarketButtonActionPerformed

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        changePnel(inventoryPanel);
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void africaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_africaButtonActionPerformed
        changePnel(africaPanel);
    }//GEN-LAST:event_africaButtonActionPerformed

    private void aisanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aisanButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aisanButtonActionPerformed

    private void australiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_australiaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_australiaButtonActionPerformed

    private void europeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_europeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_europeButtonActionPerformed

    private void nothAmericaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nothAmericaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nothAmericaButtonActionPerformed

    private void russiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_russiaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_russiaButtonActionPerformed

    private void southAmericaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_southAmericaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_southAmericaButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        changePnel(gamePanel);
    }//GEN-LAST:event_backButton1ActionPerformed

    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
       changePnel(gamePanel);
    }//GEN-LAST:event_backButton2ActionPerformed

    private void backButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton3ActionPerformed
         changePnel(gamePanel);
    }//GEN-LAST:event_backButton3ActionPerformed

    private void buyAfricaGoldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyAfricaGoldButtonActionPerformed
        try {
            game.buy(game.getMarkets()[5], 1);
        } catch (MoneyException ex) {
            
        }
    }//GEN-LAST:event_buyAfricaGoldButtonActionPerformed

    private void sellAfricaGoldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellAfricaGoldButtonActionPerformed
        try {
            game.sell(game.getMarkets()[5], 1);
        } catch (GoodsException ex) {
           
        }
    }//GEN-LAST:event_sellAfricaGoldButtonActionPerformed

    private void sellAfricaOilButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellAfricaOilButton1ActionPerformed
        try {
            game.sell(game.getMarkets()[5], 3);
        } catch (GoodsException ex) {
           
        }
    }//GEN-LAST:event_sellAfricaOilButton1ActionPerformed

    private void buyAfricaOilButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyAfricaOilButton1ActionPerformed
        try {
            game.buy(game.getMarkets()[5], 3);
        } catch (MoneyException ex) {
        }
    }//GEN-LAST:event_buyAfricaOilButton1ActionPerformed

    private void sellAfricaCopperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellAfricaCopperButtonActionPerformed
        try {
            game.sell(game.getMarkets()[5], 2);
        } catch (GoodsException ex) {
           
        }
    }//GEN-LAST:event_sellAfricaCopperButtonActionPerformed

    private void buyAfricaCopperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyAfricaCopperButtonActionPerformed
        try {
            game.buy(game.getMarkets()[5], 2);
        } catch (MoneyException ex) {
            
        }
    }//GEN-LAST:event_buyAfricaCopperButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            game.save();
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }
    
    private void updateLabels() {
        companyNameLabel.setText(game.getCompany().getName());
        monneyLabel.setText(game.getCompany().getMoney() + dollar + "");
        levelLabel.setText(game.getLevel() + "");
        
        //Inventar
        cementCountLabel.setText(game.getCompany().getGoods(8) + "");
        ceramicCountLabel.setText(game.getCompany().getGoods(6) + "");
        copperCountLabel.setText(game.getCompany().getGoods(2) + "");
        glassCountLabel.setText(game.getCompany().getGoods(5) + "");
        goldCountLabel.setText(game.getCompany().getGoods(1) + "");
        steelCountLabel.setText(game.getCompany().getGoods(4) + "");
        oilCountLabel.setText(game.getCompany().getGoods(3) + "");
        plasticCountLabel.setText(game.getCompany().getGoods(9) + "");
        woodCountLabel.setText(game.getCompany().getGoods(7) + "");
        
        //Africa
        africaCopperPriceLabel.setText(game.getMarkets()[5].getAvailableGoods()[1].getPrice() + "");
        africaGoldPriceLabel.setText(game.getMarkets()[5].getAvailableGoods()[0].getPrice() + "");
        africaOilPriceLabel.setText(game.getMarkets()[5].getAvailableGoods()[2].getPrice() + "");
    }
    
    private void start() {
        game.getCompany().setName(companyNameField.getText());
        game.start();
        gameThread.start();
        companyNameLabel.setText(game.getCompany().getName());
        updateLabels();
    }
    
    private void settings() {
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Trade Master Chronicals");
    }
    
    private void changePnel(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton africaButton;
    private javax.swing.JLabel africaCopperPriceLabel;
    private javax.swing.JLabel africaGoldPriceLabel;
    private javax.swing.JLabel africaOilPriceLabel;
    private javax.swing.JPanel africaPanel;
    private javax.swing.JButton aisanButton;
    private javax.swing.JButton australiaButton;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton backButton2;
    private javax.swing.JButton backButton3;
    private javax.swing.JButton buyAfricaCopperButton;
    private javax.swing.JButton buyAfricaGoldButton;
    private javax.swing.JButton buyAfricaOilButton1;
    private javax.swing.JLabel cementCountLabel;
    private javax.swing.JLabel ceramicCountLabel;
    private javax.swing.JLabel chipsCountLabel;
    private javax.swing.JTextField companyNameField;
    private javax.swing.JLabel companyNameLabel;
    private javax.swing.JLabel copperCountLabel;
    private javax.swing.JLabel enterameLabel;
    private javax.swing.JLabel enterameLabel1;
    private javax.swing.JLabel enterameLabel2;
    private javax.swing.JButton europeButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel glassCountLabel;
    private javax.swing.JButton globalMarketButton;
    private javax.swing.JPanel globalMarketPanel;
    private javax.swing.JLabel goldCountLabel;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton loadGameButton;
    private javax.swing.JPanel loadGamePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel monneyLabel;
    private javax.swing.JButton nothAmericaButton;
    private javax.swing.JButton npcMarketButton;
    private javax.swing.JPanel npcMarketPanel;
    private javax.swing.JLabel oilCountLabel;
    private javax.swing.JButton okayButton;
    private javax.swing.JLabel plasticCountLabel;
    private javax.swing.JButton russiaButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton sellAfricaCopperButton;
    private javax.swing.JButton sellAfricaGoldButton;
    private javax.swing.JButton sellAfricaOilButton1;
    private javax.swing.JButton southAmericaButton;
    private javax.swing.JButton startGameButton;
    private javax.swing.JPanel startGamePanel;
    private javax.swing.JLabel steelCountLabel;
    private javax.swing.JLabel woodCountLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (gameThread != null) {            
            updateLabels();
        }
    }
}
