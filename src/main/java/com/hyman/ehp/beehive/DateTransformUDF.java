package com.hyman.ehp.beehive;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class DateTransformUDF extends UDF {
	
	public Text evaluate(Text input){
		Text output = new Text();
		
		return output;
	}
}
