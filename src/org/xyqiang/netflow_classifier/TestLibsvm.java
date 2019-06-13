package org.xyqiang.netflow_classifier;

import java.io.File;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ArffLoader;

public class TestLibsvm {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Classifier classifier1;
        Classifier classifier2;
        Classifier classifier3;
    //    Classifier classifier4;

       
        File inputFile = new File(
               "F:/KDDCUP1999/Train.arff");// ѵ�������ļ�
        ArffLoader atf = new ArffLoader();
        atf.setFile(inputFile);
        Instances instancesTrain = atf.getDataSet(); // ����ѵ���ļ�
       
        inputFile = new File(
               "F:/KDDCUP1999/Test.arff");// ���������ļ�
        atf.setFile(inputFile);
        Instances instancesTest = atf.getDataSet(); // ��������ļ�

       
        instancesTest.setClassIndex(instancesTest.numAttributes() - 1);
        instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);

       
       // ���ر�Ҷ˹�㷨
        classifier1 = (Classifier) Class.forName(
               "weka.classifiers.bayes.NaiveBayes").newInstance();
        // ������
        classifier2 = (Classifier) Class.forName(
               "weka.classifiers.trees.J48").newInstance();
        // Zero
        classifier3 = (Classifier) Class.forName(
               "weka.classifiers.rules.ZeroR").newInstance();
        // LibSVM
    //    classifier4 = (Classifier) Class.forName("weka.classifiers.functions.LibSVM").newInstance();
        
    // classifier4.buildClassifier(instancesTrain);
        classifier1.buildClassifier(instancesTrain);
        classifier2.buildClassifier(instancesTrain);
        classifier3.buildClassifier(instancesTrain);
        
        SerializationHelper.write("F:/KDDCUP1999/NaiveBayes.model", classifier1);
        SerializationHelper.write("F:/KDDCUP1999/J48_test.model", classifier2);
        SerializationHelper.write("F:/KDDCUP1999/ZeroR.model", classifier3);     
       
        
//        Evaluation eval = new Evaluation(instancesTrain);
//       
////        eval.evaluateModel(classifier4, instancesTest);
////      	System.out.println("LibSVM�㷨�������"+"\n"+eval.toSummaryString()+"\n"+eval.toClassDetailsString());
//        eval.evaluateModel(classifier1, instancesTest);
//        System.out.println("���ر�Ҷ˹�㷨�������"+"\n"+eval.toSummaryString()+"\n"+eval.toClassDetailsString());
//        eval.evaluateModel(classifier2, instancesTest);
//        System.out.println("�������㷨�������"+"\n"+eval.toSummaryString()+"\n"+eval.toClassDetailsString());
//        eval.evaluateModel(classifier3, instancesTest);
//        System.out.println("Zero�㷨�������"+"\n"+eval.toSummaryString()+"\n"+eval.toClassDetailsString());
       


    }

/*���ֻ��ѵ����������ʮ������֤�ķ�����������ĵ�5���͵�6������Ϊ���´��룺
       
        Evaluation eval = new Evaluation(instancesTrain);
        eval.crossValidateModel(classifier4, instancesTrain, 10, new Random(1));
        System.out.println(eval.errorRate());
        eval.crossValidateModel(classifier1, instancesTrain, 10, new Random(1));
        System.out.println(eval.errorRate());
        eval.crossValidateModel(classifier2, instancesTrain, 10, new Random(1));
        System.out.println(eval.errorRate());
        eval.crossValidateModel(classifier3, instancesTrain, 10, new Random(1));
        System.out.println(eval.errorRate());
�����Ҫ����ͼ��ط�����ģ�Ͳ������ڵ�5���͵�6��֮��������´��룺
       
        SerializationHelper.write("LibSVM.model", classifier4);
       
       
       
        Classifier classifier8 = (Classifier) weka.core.SerializationHelper.read("LibSVM.model");
        Classifier classifier5 = (Classifier) weka.core.SerializationHelper.read("NaiveBayes.model");
        Classifier classifier6 = (Classifier) weka.core.SerializationHelper.read("J48.model");
        Classifier classifier7 = (Classifier) weka.core.SerializationHelper.read("ZeroR.model");*/
}

