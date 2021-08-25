using CloneDetectorTool.Models;
using Microsoft.WindowsAPICodePack.Dialogs;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CloneDetectorTool
{
    public partial class CodeCloneDetectorForm : Form
    {
        private BindingSource source;
        private string pathToJar = @"\MLModels\clonedetector.jar";
        private string pathToFindModel = @"\MLModels\J48.model";
        private string pathToOutput = @"\MLModels\Predictions.txt";

        public CodeCloneDetectorForm()
        {
            InitializeComponent();
            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;

            // Bind list to datasource
            /*
            var list = new List<CloneDetectionResultModel>();
            var bindingList = new BindingList<CloneDetectionResultModel>(list);
            source = new BindingSource(bindingList, null);
            cloneDetectionResultView.DataSource = source;
            */

            cloneDetectionResultView.Columns[0].SortMode = DataGridViewColumnSortMode.Automatic;
            cloneDetectionResultView.Refresh();

        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void selectDirectoryButton_Click(object sender, EventArgs e)
        {
            CommonOpenFileDialog dialog = new CommonOpenFileDialog();
            dialog.InitialDirectory = "C:\\Users";
            dialog.IsFolderPicker = true;
            if (dialog.ShowDialog() == CommonFileDialogResult.Ok)
            {
                selectedDirectoryTextBox.Text = dialog.FileName;
            }
        }

        private void DetectClones()
        {
            // this.source.Clear();
            cloneDetectionResultModelBindingSource.Clear();

            List<CloneDetectionResultModel> results = new List<CloneDetectionResultModel>();
            String line;
            System.IO.StreamReader file = new System.IO.StreamReader(pathToOutput);


            List<CloneDetectionResultModel> detectionlist = new List<CloneDetectionResultModel>();

            while ((line = file.ReadLine()) != null)
            {
                CloneDetectionResultModel result = new CloneDetectionResultModel();
                String[] prediction = line.Split(';');
                result.FilePath = prediction[0];
                result.FileName = prediction[1];
                result.StartLine = Int32.Parse(prediction[2]);
                result.EndLine = Int32.Parse(prediction[3]);
                result.TargetFilePath = prediction[4];
                result.TargetFileName = prediction[5];
                result.TargetStartLine = Int32.Parse(prediction[6]);
                result.TargetEndLine = Int32.Parse(prediction[7]);
                result.Prediction = Math.Round(Double.Parse(prediction[8].Replace('.', ',')), 2);
                result.PredictionName = prediction[9];
                // this.source.Add(result);
                detectionlist.Add(result);
            }

            detectionlist = detectionlist.OrderBy(x =>
                x.PredictionName == "TYPE1" ? 1:
                x.PredictionName == "TYPE2" ? 2:
                x.PredictionName == "VST3" ? 3:
                x.PredictionName == "ST3" ? 4:
                x.PredictionName == "MT3" ? 5:
                x.PredictionName == "WT3" ? 6:
                7
                ).ToList();

            foreach(var clone in detectionlist)
                cloneDetectionResultModelBindingSource.Add(clone);
                        
            file.Close();
        }

        public void RunCloneDetectionTool()
        {
            System.Diagnostics.Process process = new System.Diagnostics.Process();
            System.Diagnostics.ProcessStartInfo startInfo = new System.Diagnostics.ProcessStartInfo();
            startInfo.WindowStyle = System.Diagnostics.ProcessWindowStyle.Hidden;
            startInfo.FileName = "cmd.exe";

            string pathToInput = this.selectedDirectoryTextBox.Text;

            startInfo.Arguments = "/C java -jar " + pathToJar + " " + pathToFindModel + " " + pathToOutput + " " + pathToInput;
                        
            process.StartInfo = startInfo;
            process.Start();
            process.WaitForExit();

            // Update the list
            DetectClones();
        }

        private void cloneDetectionResultView_SelectionChanged(object sender, EventArgs e)
        {
            if (cloneDetectionResultView.SelectedRows.Count == 0)
                return;

            var row = cloneDetectionResultView.SelectedRows[0];
            if (row == null)
                return;

            var rowdata = (CloneDetectionResultModel) row.DataBoundItem;

            string sourceCodePath = rowdata.FilePath;
            string targetCodePath = rowdata.TargetFilePath;

            int sourceStartLine = rowdata.StartLine;
            int targetStartLine = rowdata.TargetStartLine;

            int sourceEndLine = rowdata.EndLine;
            int targetEndLine = rowdata.TargetEndLine;

            SelectedResultOneTextBox.Text = rowdata.FilePath;
            SelectedResultTwoTextBox.Text = rowdata.TargetFilePath;

            SelectedResultOneCodeBox.Text = ReadBetweenLines(sourceCodePath, sourceStartLine, sourceEndLine);
            SelectedResultTwoCodeBox.Text = ReadBetweenLines(targetCodePath, targetStartLine, targetEndLine);

        }

        private string ReadBetweenLines(string fullPath, int startLine, int endLine)
        {
            string line;
            string result = "";
            System.IO.StreamReader file = new System.IO.StreamReader(fullPath);
            int lineCount = 0;
            while ((line = file.ReadLine()) != null)
            {
                lineCount++;
                if (lineCount >= startLine && lineCount <= endLine) 
                    result += line + Environment.NewLine;
            }
            file.Close();
            return result;
        }

        private void detectClonesButton_Click(object sender, EventArgs e)
        {
            if (this.selectedDirectoryTextBox.Text == "")
            {
                MessageBox.Show("Please select a directory");
                return;
            }
            
            RunCloneDetectionTool();
        }
    }
}
