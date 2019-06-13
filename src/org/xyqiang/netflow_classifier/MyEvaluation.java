package org.xyqiang.netflow_classifier;
/**
 * �ó����ڛQ�ߘ�ķ�����ģ�Ϳ��ӻ�Ч�����������
 * */
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class MyEvaluation {
		
	/** ��ȡѵ�����Ķ��� */	
	private  Instances train;
	
	/** ��ȡ���Լ��Ķ��� */	
	private  Instances test;	
	
	/** ���ɵľ�����ģ�� */	
	private  J48 tree;
	
	/** ���������ַ������ģ��  */	
	private  String trees;
	
	/** ����������ַ������ */	
	private  String evaluateData;
	
	/**
	 * ���������ַ������ģ�͵Ļ�ȡ����
	 * 
	 * @return ���к����ɵ�String�;�����ģ��
	 */		
	public String getTrees() {
		return trees;
	}	
	
	public void setTrees(String trees) {
		this.trees = trees;
	}
	
	/**
	 * ����������ַ�������Ļ�ȡ����
	 * 
	 * @return ���к����ɵ�String���������
	 */	
	public String getEvaluateData() {
		return evaluateData;
	}
	
	public void setEvaluateData(String evaluateData) {
		this.evaluateData = evaluateData;
	}	
	
	/**
	 * ѵ��������Ļ�ȡ
	 * 
	 * @return ��ȡ��ѵ���������ھ�����������
	 */	
	public Instances getTrain() {
		return train;
	}
	
	public void setTrain(Instances train) {
		this.train = train;
	}
	
	/**
	 * ���Լ�����Ļ�ȡ
	 * 
	 * @return ��ȡ�Ĳ��Լ��������������������
	 */	
	public Instances getTest() {
		return test;
	}
	
	public void setTest(Instances test) {
		this.test = test;
	}
	
	/**
	 * ������ģ�͵Ļ�ȡ��ʽ
	 * 
	 * @return �������ɵ�J48����󣬴����ľ�����ģ�ͣ�������Ԥ�������
	 */	
	public J48 getTree() {
		return tree;
	}
	
	public void setTree(J48 tree) {
		this.tree = tree;
	}
			
	/**
	 * J48�ഴ������������
	 * ��������ѡ���������ע�ͣ��ؼ���buildClassifier����
	 * 
	 * @return ������ģ�͡���tree
	 */	
	public J48 model() throws Exception {						
		// ѵ��J48������
		String[] options = new String[1];
		options[0] = "-U"; 			// ���޼�
		tree = new J48(); 			// J48����������
		tree.setOptions(options);	// ����ѡ��
		tree.buildClassifier(train);// ����������	
		return tree;
	}
	
	/**
	 * ����ѵ����
	 * 
	 * @return ѵ��������train
	 */	
	public Instances TrainLoader() throws Exception {
		train = DataSource.read("F:/KDDCUP1999/Train.arff");
		train.setClassIndex(train.numAttributes() - 1);
		return train;
	}
	
	/**
	 * ����ѵ����
	 * 
	 * @return ѵ��������test
	 */	
	public Instances TestLoader() throws Exception {
		test  = DataSource.read("F:/KDDCUP1999/Test.arff");
		test.setClassIndex(test.numAttributes() - 1);
		return test;
	}
	
	/**
	 * �ھ���������֮�����ַ�������ʽչ�ֳ���
	 * toString����ת�����ַ�����һ���������൱�ڸ�trees��ֵ
	 * 
	 * @return ���������ַ�����ʽ����trees
	 */	
	public void buildtree() throws Exception {
		setTrees(tree.toString());
	}
	
	/**
	 * �Խ����õ�ģ�ͽ�����������
	 * ���غò��Լ�������ʶ���һ����
	 * 
	 * @return �����������evaluateData
	 */	
	public void evaluate() throws Exception {
		Evaluation eval = new Evaluation(train);
		eval.evaluateModel(tree, test);
		setEvaluateData(eval.toSummaryString()+"/n"+eval.toClassDetailsString());
		
	}
	
	/**
	 * �����������ڲ���
	 * 
	 */	
	public static void main(String[] args) throws Exception {
		try {
			MyEvaluation a = new MyEvaluation();
			a.TrainLoader();
			a.TestLoader();
			a.model();
			a.evaluate();	
			System.out.print(a.getTree());
			System.out.print(a.getEvaluateData());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
