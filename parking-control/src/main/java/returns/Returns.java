package returns;

public class Returns {

	private String msg;
	private String result;
	private String cat;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Returns [msg=" + msg + ", result=" + result + ", cat=" + cat + "]";
	}
	
	public Returns() {
		
	}
	
	
}
