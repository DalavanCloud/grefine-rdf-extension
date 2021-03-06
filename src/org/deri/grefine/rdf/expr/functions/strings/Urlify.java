package org.deri.grefine.rdf.expr.functions.strings;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.google.refine.expr.EvalError;
import com.google.refine.grel.ControlFunctionRegistry;
import com.google.refine.grel.Function;

public class Urlify implements Function {

    public Object call(Properties bindings, Object[] args) {
        if(args.length==1){
            String s = args[0].toString();
            if(s.isEmpty()){
            	return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " Cannot urlify empty string");
            }
            s = s.toLowerCase().replaceAll("\\s+", "-").replaceAll("[^-a-zA-Z0-9]", "").replaceAll("\\-\\-+", "-");
            return s;
        }
        return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " expects 1 string");
    }

    public void write(JSONWriter writer, Properties options)
            throws JSONException {
        writer.object();
        writer.key("description"); writer.value("replaces spaces with underscore");
        writer.key("params"); writer.value("string s");
        writer.key("returns"); writer.value("string");
        writer.endObject();
        
    }

}
