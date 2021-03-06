package graphtools;

import java.io.*;
import java.util.*;
import java.lang.*;
import heap.*;
import bufmgr.*;
import diskmgr.*;
import edgeheap.*;
import global.*;
import btree.*;
import graphtools.*;

class EdgeWeightDriver implements GlobalConst {
	public int keyType = AttrType.attrInteger;
	public BTreeFile file;
	public HFManager hfm = null;
	public BTManager btm = null;

	protected String dbpath;

	EdgeWeightDriver() {

	}

	EdgeWeightDriver(HFManager hfms, BTManager btms) {
		this.hfm = hfms;
		this.btm = btms;
	}

	public void runTests() throws Exception {
		System.out.println("start constructing Edgeweight BTree!!!");
		ConstructBTEW();
//		System.out.println("start test 2!!!");
//		BT.printBTree(btm.getEdgeweightbtree().getHeaderPage());
//		System.out.println("start test 3!!!");
//		BT.printAllLeafPages(btm.getEdgeweightbtree().getHeaderPage());

	}

	public void ConstructBTEW() throws Exception {

		keyType = AttrType.attrInteger;
		file = new BTreeFile("EdgeWeightTree", keyType, 4, 1);// full delete
		Edge edge = new Edge();
		KeyClass key;
		RID rid = new RID();
		hfm.initScanEdge();

		while ((edge = hfm.scanNextEdge()) != null) {
			key = new IntegerKey(edge.getWeight());
			rid = hfm.getCurRID();
			file.insert(key, rid);
		}
		btm.setEdgeweightbtree(file);
	}
}

public class EdgeWeight implements GlobalConst {
	public static void main(String[] argvs) {
		System.out.println("testing!!!");

		EdgeLabelsDriver test = new EdgeLabelsDriver();
		try {
			test.runTests();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buildEdgeIndex(HFManager hfm) {
		EdgeLabelsDriver test = new EdgeLabelsDriver();
		try {
			test.runTests();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
