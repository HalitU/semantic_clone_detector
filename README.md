# Code Clone Detection Using Syntactic and Semantic Properties
A code clone detection tool using [BigCloneEval](https://jeffsvajlenko.weebly.com/bigcloneeval.html) database. In order to check its contents you might want to use [h2 database engine](https://www.h2database.com/html/main.html). However, I would like to warn that the database ise quite big, therefore indexing is strongly recommended to speed up your queries. More information on how to use the code as well as a very simple gui designed for it can be seen in the "README & GUIDELINES" pdf document. Keep in mind that this is just a machine learning approach, and there are many other clone detection tools out there which can easily detect type1-2 clones very fast and accuretly. I thought it would be interesting to include this study here just in case if someone wants to see how the corresponding db can be utilized.

There are also some .arf files which can be used either using the [Weka](https://www.cs.waikato.ac.nz/ml/weka/) java api, or directly from the weka application itself.

If you want to learn more about the study, checkout the report which is written in IEEE format, or the simple presentation which summarizes things up.

Following paper was referenced while improving the detection tool and implementing an algorithm:

A. Sheneamer and J. Kalita, “Semantic clone detection using machine
learning,” in 2016 15th IEEE International Conference on Machine
Learning and Applications (ICMLA). IEEE, 2016, pp. 1024–1028. [IEEE Link](https://ieeexplore.ieee.org/document/7838289)
