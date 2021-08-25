
namespace CloneDetectorTool
{
    partial class CodeCloneDetectorForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.cloneDetectionResultView = new System.Windows.Forms.DataGridView();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.SelectedResultOneCodeBox = new System.Windows.Forms.TextBox();
            this.SelectedResultTwoCodeBox = new System.Windows.Forms.TextBox();
            this.SelectedResultOneTextBox = new System.Windows.Forms.TextBox();
            this.SelectedResultTwoTextBox = new System.Windows.Forms.TextBox();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.selectedDirectoryTextBox = new System.Windows.Forms.TextBox();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel2 = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel4 = new System.Windows.Forms.TableLayoutPanel();
            this.selectDirectoryButton = new System.Windows.Forms.Button();
            this.detectClonesButton = new System.Windows.Forms.Button();
            this.tableLayoutPanel3 = new System.Windows.Forms.TableLayoutPanel();
            this.predictionNameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.predictionDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fileNameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.startLineDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.endLineDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.filePathDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.targetFileNameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.targetStartLineDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.targetEndLineDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.targetFilePathDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.cloneDetectionResultModelBindingSource = new System.Windows.Forms.BindingSource(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.cloneDetectionResultView)).BeginInit();
            this.tableLayoutPanel1.SuspendLayout();
            this.tableLayoutPanel2.SuspendLayout();
            this.tableLayoutPanel4.SuspendLayout();
            this.tableLayoutPanel3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.cloneDetectionResultModelBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // cloneDetectionResultView
            // 
            this.cloneDetectionResultView.AllowUserToAddRows = false;
            this.cloneDetectionResultView.AllowUserToDeleteRows = false;
            this.cloneDetectionResultView.AllowUserToOrderColumns = true;
            this.cloneDetectionResultView.AutoGenerateColumns = false;
            this.cloneDetectionResultView.BackgroundColor = System.Drawing.SystemColors.Window;
            this.cloneDetectionResultView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.cloneDetectionResultView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.predictionNameDataGridViewTextBoxColumn,
            this.predictionDataGridViewTextBoxColumn,
            this.fileNameDataGridViewTextBoxColumn,
            this.startLineDataGridViewTextBoxColumn,
            this.endLineDataGridViewTextBoxColumn,
            this.filePathDataGridViewTextBoxColumn,
            this.targetFileNameDataGridViewTextBoxColumn,
            this.targetStartLineDataGridViewTextBoxColumn,
            this.targetEndLineDataGridViewTextBoxColumn,
            this.targetFilePathDataGridViewTextBoxColumn});
            this.cloneDetectionResultView.DataSource = this.cloneDetectionResultModelBindingSource;
            this.cloneDetectionResultView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.cloneDetectionResultView.Location = new System.Drawing.Point(3, 90);
            this.cloneDetectionResultView.MultiSelect = false;
            this.cloneDetectionResultView.Name = "cloneDetectionResultView";
            this.cloneDetectionResultView.ReadOnly = true;
            this.cloneDetectionResultView.Size = new System.Drawing.Size(418, 457);
            this.cloneDetectionResultView.TabIndex = 0;
            this.cloneDetectionResultView.SelectionChanged += new System.EventHandler(this.cloneDetectionResultView_SelectionChanged);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // SelectedResultOneCodeBox
            // 
            this.SelectedResultOneCodeBox.BackColor = System.Drawing.SystemColors.Info;
            this.SelectedResultOneCodeBox.Dock = System.Windows.Forms.DockStyle.Fill;
            this.SelectedResultOneCodeBox.Location = new System.Drawing.Point(3, 25);
            this.SelectedResultOneCodeBox.Multiline = true;
            this.SelectedResultOneCodeBox.Name = "SelectedResultOneCodeBox";
            this.SelectedResultOneCodeBox.ReadOnly = true;
            this.SelectedResultOneCodeBox.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.SelectedResultOneCodeBox.Size = new System.Drawing.Size(708, 252);
            this.SelectedResultOneCodeBox.TabIndex = 3;
            // 
            // SelectedResultTwoCodeBox
            // 
            this.SelectedResultTwoCodeBox.BackColor = System.Drawing.SystemColors.Info;
            this.SelectedResultTwoCodeBox.Dock = System.Windows.Forms.DockStyle.Fill;
            this.SelectedResultTwoCodeBox.Location = new System.Drawing.Point(3, 309);
            this.SelectedResultTwoCodeBox.Multiline = true;
            this.SelectedResultTwoCodeBox.Name = "SelectedResultTwoCodeBox";
            this.SelectedResultTwoCodeBox.ReadOnly = true;
            this.SelectedResultTwoCodeBox.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.SelectedResultTwoCodeBox.Size = new System.Drawing.Size(708, 238);
            this.SelectedResultTwoCodeBox.TabIndex = 4;
            // 
            // SelectedResultOneTextBox
            // 
            this.SelectedResultOneTextBox.Dock = System.Windows.Forms.DockStyle.Fill;
            this.SelectedResultOneTextBox.Location = new System.Drawing.Point(3, 3);
            this.SelectedResultOneTextBox.Name = "SelectedResultOneTextBox";
            this.SelectedResultOneTextBox.ReadOnly = true;
            this.SelectedResultOneTextBox.Size = new System.Drawing.Size(708, 20);
            this.SelectedResultOneTextBox.TabIndex = 5;
            // 
            // SelectedResultTwoTextBox
            // 
            this.SelectedResultTwoTextBox.Dock = System.Windows.Forms.DockStyle.Fill;
            this.SelectedResultTwoTextBox.Location = new System.Drawing.Point(3, 283);
            this.SelectedResultTwoTextBox.Name = "SelectedResultTwoTextBox";
            this.SelectedResultTwoTextBox.ReadOnly = true;
            this.SelectedResultTwoTextBox.Size = new System.Drawing.Size(708, 20);
            this.SelectedResultTwoTextBox.TabIndex = 6;
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // selectedDirectoryTextBox
            // 
            this.selectedDirectoryTextBox.Dock = System.Windows.Forms.DockStyle.Fill;
            this.selectedDirectoryTextBox.Location = new System.Drawing.Point(3, 3);
            this.selectedDirectoryTextBox.Name = "selectedDirectoryTextBox";
            this.selectedDirectoryTextBox.Size = new System.Drawing.Size(418, 20);
            this.selectedDirectoryTextBox.TabIndex = 8;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.AutoSize = true;
            this.tableLayoutPanel1.ColumnCount = 1;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Controls.Add(this.SelectedResultTwoTextBox, 0, 2);
            this.tableLayoutPanel1.Controls.Add(this.SelectedResultTwoCodeBox, 0, 3);
            this.tableLayoutPanel1.Controls.Add(this.SelectedResultOneCodeBox, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.SelectedResultOneTextBox, 0, 0);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(433, 3);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 4;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 8.083833F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 91.91617F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 26F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 243F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(714, 550);
            this.tableLayoutPanel1.TabIndex = 9;
            this.tableLayoutPanel1.Paint += new System.Windows.Forms.PaintEventHandler(this.tableLayoutPanel1_Paint);
            // 
            // tableLayoutPanel2
            // 
            this.tableLayoutPanel2.ColumnCount = 1;
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel2.Controls.Add(this.selectedDirectoryTextBox, 0, 0);
            this.tableLayoutPanel2.Controls.Add(this.cloneDetectionResultView, 0, 2);
            this.tableLayoutPanel2.Controls.Add(this.tableLayoutPanel4, 0, 1);
            this.tableLayoutPanel2.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel2.Name = "tableLayoutPanel2";
            this.tableLayoutPanel2.RowCount = 3;
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 28.73563F));
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 71.26437F));
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 462F));
            this.tableLayoutPanel2.Size = new System.Drawing.Size(424, 550);
            this.tableLayoutPanel2.TabIndex = 10;
            // 
            // tableLayoutPanel4
            // 
            this.tableLayoutPanel4.ColumnCount = 2;
            this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel4.Controls.Add(this.selectDirectoryButton, 0, 0);
            this.tableLayoutPanel4.Controls.Add(this.detectClonesButton, 1, 0);
            this.tableLayoutPanel4.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel4.Location = new System.Drawing.Point(3, 28);
            this.tableLayoutPanel4.Name = "tableLayoutPanel4";
            this.tableLayoutPanel4.RowCount = 1;
            this.tableLayoutPanel4.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel4.Size = new System.Drawing.Size(418, 56);
            this.tableLayoutPanel4.TabIndex = 7;
            // 
            // selectDirectoryButton
            // 
            this.selectDirectoryButton.Location = new System.Drawing.Point(3, 3);
            this.selectDirectoryButton.Name = "selectDirectoryButton";
            this.selectDirectoryButton.Size = new System.Drawing.Size(203, 50);
            this.selectDirectoryButton.TabIndex = 7;
            this.selectDirectoryButton.Text = "Select Directory";
            this.selectDirectoryButton.UseVisualStyleBackColor = true;
            this.selectDirectoryButton.Click += new System.EventHandler(this.selectDirectoryButton_Click);
            // 
            // detectClonesButton
            // 
            this.detectClonesButton.Dock = System.Windows.Forms.DockStyle.Fill;
            this.detectClonesButton.Location = new System.Drawing.Point(212, 3);
            this.detectClonesButton.Name = "detectClonesButton";
            this.detectClonesButton.Size = new System.Drawing.Size(203, 50);
            this.detectClonesButton.TabIndex = 8;
            this.detectClonesButton.Text = "Detect Clones";
            this.detectClonesButton.UseVisualStyleBackColor = true;
            this.detectClonesButton.Click += new System.EventHandler(this.detectClonesButton_Click);
            // 
            // tableLayoutPanel3
            // 
            this.tableLayoutPanel3.AutoSize = true;
            this.tableLayoutPanel3.ColumnCount = 2;
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 37.4269F));
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 62.5731F));
            this.tableLayoutPanel3.Controls.Add(this.tableLayoutPanel1, 1, 0);
            this.tableLayoutPanel3.Controls.Add(this.tableLayoutPanel2, 0, 0);
            this.tableLayoutPanel3.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel3.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel3.Name = "tableLayoutPanel3";
            this.tableLayoutPanel3.RowCount = 1;
            this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 556F));
            this.tableLayoutPanel3.Size = new System.Drawing.Size(1150, 556);
            this.tableLayoutPanel3.TabIndex = 11;
            // 
            // predictionNameDataGridViewTextBoxColumn
            // 
            this.predictionNameDataGridViewTextBoxColumn.DataPropertyName = "PredictionName";
            this.predictionNameDataGridViewTextBoxColumn.HeaderText = "PredictionName";
            this.predictionNameDataGridViewTextBoxColumn.Name = "predictionNameDataGridViewTextBoxColumn";
            this.predictionNameDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // predictionDataGridViewTextBoxColumn
            // 
            this.predictionDataGridViewTextBoxColumn.DataPropertyName = "Prediction";
            this.predictionDataGridViewTextBoxColumn.HeaderText = "Prediction";
            this.predictionDataGridViewTextBoxColumn.Name = "predictionDataGridViewTextBoxColumn";
            this.predictionDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // fileNameDataGridViewTextBoxColumn
            // 
            this.fileNameDataGridViewTextBoxColumn.DataPropertyName = "FileName";
            this.fileNameDataGridViewTextBoxColumn.HeaderText = "FileName";
            this.fileNameDataGridViewTextBoxColumn.Name = "fileNameDataGridViewTextBoxColumn";
            this.fileNameDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // startLineDataGridViewTextBoxColumn
            // 
            this.startLineDataGridViewTextBoxColumn.DataPropertyName = "StartLine";
            this.startLineDataGridViewTextBoxColumn.HeaderText = "StartLine";
            this.startLineDataGridViewTextBoxColumn.Name = "startLineDataGridViewTextBoxColumn";
            this.startLineDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // endLineDataGridViewTextBoxColumn
            // 
            this.endLineDataGridViewTextBoxColumn.DataPropertyName = "EndLine";
            this.endLineDataGridViewTextBoxColumn.HeaderText = "EndLine";
            this.endLineDataGridViewTextBoxColumn.Name = "endLineDataGridViewTextBoxColumn";
            this.endLineDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // filePathDataGridViewTextBoxColumn
            // 
            this.filePathDataGridViewTextBoxColumn.DataPropertyName = "FilePath";
            this.filePathDataGridViewTextBoxColumn.HeaderText = "FilePath";
            this.filePathDataGridViewTextBoxColumn.Name = "filePathDataGridViewTextBoxColumn";
            this.filePathDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // targetFileNameDataGridViewTextBoxColumn
            // 
            this.targetFileNameDataGridViewTextBoxColumn.DataPropertyName = "TargetFileName";
            this.targetFileNameDataGridViewTextBoxColumn.HeaderText = "TargetFileName";
            this.targetFileNameDataGridViewTextBoxColumn.Name = "targetFileNameDataGridViewTextBoxColumn";
            this.targetFileNameDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // targetStartLineDataGridViewTextBoxColumn
            // 
            this.targetStartLineDataGridViewTextBoxColumn.DataPropertyName = "TargetStartLine";
            this.targetStartLineDataGridViewTextBoxColumn.HeaderText = "TargetStartLine";
            this.targetStartLineDataGridViewTextBoxColumn.Name = "targetStartLineDataGridViewTextBoxColumn";
            this.targetStartLineDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // targetEndLineDataGridViewTextBoxColumn
            // 
            this.targetEndLineDataGridViewTextBoxColumn.DataPropertyName = "TargetEndLine";
            this.targetEndLineDataGridViewTextBoxColumn.HeaderText = "TargetEndLine";
            this.targetEndLineDataGridViewTextBoxColumn.Name = "targetEndLineDataGridViewTextBoxColumn";
            this.targetEndLineDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // targetFilePathDataGridViewTextBoxColumn
            // 
            this.targetFilePathDataGridViewTextBoxColumn.DataPropertyName = "TargetFilePath";
            this.targetFilePathDataGridViewTextBoxColumn.HeaderText = "TargetFilePath";
            this.targetFilePathDataGridViewTextBoxColumn.Name = "targetFilePathDataGridViewTextBoxColumn";
            this.targetFilePathDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // cloneDetectionResultModelBindingSource
            // 
            this.cloneDetectionResultModelBindingSource.DataSource = typeof(CloneDetectorTool.Models.CloneDetectionResultModel);
            this.cloneDetectionResultModelBindingSource.Filter = "";
            // 
            // CodeCloneDetectorForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1150, 556);
            this.Controls.Add(this.tableLayoutPanel3);
            this.Name = "CodeCloneDetectorForm";
            this.Text = "Code Clone Decetor";
            ((System.ComponentModel.ISupportInitialize)(this.cloneDetectionResultView)).EndInit();
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.tableLayoutPanel2.ResumeLayout(false);
            this.tableLayoutPanel2.PerformLayout();
            this.tableLayoutPanel4.ResumeLayout(false);
            this.tableLayoutPanel3.ResumeLayout(false);
            this.tableLayoutPanel3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.cloneDetectionResultModelBindingSource)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView cloneDetectionResultView;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.TextBox SelectedResultOneCodeBox;
        private System.Windows.Forms.TextBox SelectedResultTwoCodeBox;
        private System.Windows.Forms.TextBox SelectedResultOneTextBox;
        private System.Windows.Forms.TextBox SelectedResultTwoTextBox;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.TextBox selectedDirectoryTextBox;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel2;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel3;
        private System.Windows.Forms.Button selectDirectoryButton;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel4;
        private System.Windows.Forms.Button detectClonesButton;
        private System.Windows.Forms.DataGridViewTextBoxColumn predictionNameDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn predictionDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn fileNameDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn startLineDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn endLineDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn filePathDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn targetFileNameDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn targetStartLineDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn targetEndLineDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn targetFilePathDataGridViewTextBoxColumn;
        private System.Windows.Forms.BindingSource cloneDetectionResultModelBindingSource;
    }
}

