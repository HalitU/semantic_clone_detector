using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CloneDetectorTool.Models
{
    public class CloneDetectionResultModel
    {
        public string PredictionName { get; set; }
        public double Prediction { get; set; }
        public string FileName { get; set; }
        public int StartLine { get; set; }
        public int EndLine { get; set; }
        public string FilePath { get; set; }
        public string TargetFileName { get; set; }
        public int TargetStartLine { get; set; }
        public int TargetEndLine { get; set; }
        public string TargetFilePath { get; set; }
    }
}
