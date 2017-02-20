package com.cheyifu.wsl.myapplication;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONUtil {
	
	/**
	 * @描述：将对象转换为json
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param object 要转换的对象
	 * @return json字符串
	 */
	public static String parseObject(final Object object) {
		ObjectMapper om=new ObjectMapper();
		String ret=null;
		try {
			om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * @描述：将对象转换为json
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param object 要转换的对象
	 * @return json字符串
	 */
	public static String parseObject(final Object object,boolean isNumberToString) {
		ObjectMapper om=new ObjectMapper();
		String ret=null;
		try {
			om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			
			if(isNumberToString){
				om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
			}
			/*//临时解决方案，null转为字符串（数值类型 现在也会转，后期找解决方案）
			om.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()  
		        {  
					@Override
					public void serialize(Object arg0, JsonGenerator arg1,
							SerializerProvider arg2) throws IOException,
							JsonProcessingException {
						
						arg1.writeString("");
					}  
		        }); */
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
		}
		return ret;
	}
	
	/**
	 * @描述：将对象转换为json
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param object 要转换的对象
	 * @param filterob 过滤器名称
	 * @param specifypro 要转换的字段
	 * @return json字符串
	 */
	public static String parseObject(final Object object, final String filterob,final String[] specifypro){
		ObjectMapper om = new ObjectMapper();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		om.getSerializationConfig().setDateFormat(df);

		SimpleFilterProvider filter = new SimpleFilterProvider().setFailOnUnknownId(false);
		filter.addFilter(filterob, SimpleBeanPropertyFilter.filterOutAllExcept(specifypro));
		om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		om.setFilters(filter);
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ret;
	}
	
	/**
	 * @描述：将对象转换为json
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param object 要转换的对象
	 * @param filterMap 过滤器map
	 * @param dateFormat 日期的格式化模式
	 * @return json字符串
	 */
	public static String parseObject(Object object,Map<String, String[]> filterMap,String dateFormat){
		ObjectMapper om = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		om.setDateFormat(format);
		SimpleFilterProvider filter = new SimpleFilterProvider().setFailOnUnknownId(false);
		for (Map.Entry<String, String[]> mapItem : filterMap.entrySet()) {
			filter.addFilter(mapItem.getKey(), SimpleBeanPropertyFilter.filterOutAllExcept(mapItem.getValue()));
		}
		om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		om.setFilters(filter);
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ret;
	}
	
	/**
	 * @描述：将对象转换为json
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param object 要转换的对象
	 * @param dateFormat 日期的格式化模式
	 * @return json字符串
	 */
	public static String parseObject(Object object,String dateFormat){
		ObjectMapper om = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		om.setDateFormat(format);
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ret;
	}
	
	/**
	 * @描述：将对象转换为json
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param object 要转换的对象
	 * @param filterMap 过滤器map
	 * @return json字符串
	 */
	public static String parseObject(Object object,Map<String, String[]> filterMap){
		ObjectMapper om = new ObjectMapper();
		SimpleFilterProvider filter = new SimpleFilterProvider().setFailOnUnknownId(false);
		for (Map.Entry<String, String[]> mapItem : filterMap.entrySet()) {
			filter.addFilter(mapItem.getKey(), SimpleBeanPropertyFilter.filterOutAllExcept(mapItem.getValue()));
		}
		om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		om.setFilters(filter);
		String ret=null;
		try {
			ret=om.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ret;
	}
	
	/**
	 * 获取对象的json表达式,忽略对象的空字段
	 * @param object
	 * @return
	 */
	public static String parseObjectIgnoreNull(final Object object,String datePattern){
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
		SimpleDateFormat sf = new SimpleDateFormat(datePattern);
		mapper.setDateFormat(sf);
		try {
			json = mapper.writeValueAsString(object);
		}catch(Exception e) {
		}
		return json;
	}
	
	/**
	 * @描述：将json解析为对象
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param jsonstr 要解析的json字符串
	 * @param clazz 目标对象的字节码对象
	 * @return 转换后的对象
	 */
	public static  <T> T readJson2Entity(String jsonstr,Class<T> clazz){
		try {
			ObjectMapper om = new ObjectMapper();
			om.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true); 
	        T acc = om.readValue(jsonstr, clazz);
	        return acc;
	    } catch (JsonParseException e) {
	    } catch (JsonMappingException e) {
	    } catch (IOException e) {
	    }
		return null;
	}
	
	/**
	 * @描述：将json解析为对象
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param jsonstr 要解析的json字符串
	 * @param object 目标对象同类型的对象
	 * @param filterob 过滤器名称
	 * @param specifypro 要转换的字段
	 * @return 转换后的对象
	 */
	public static Object readJson2Entity(String jsonstr , final Object object, final String filterob,final String[] specifypro){
		try {
			ObjectMapper om = new ObjectMapper();
			SimpleFilterProvider filter = new SimpleFilterProvider().setFailOnUnknownId(false);
			filter.addFilter(filterob, SimpleBeanPropertyFilter.filterOutAllExcept(specifypro));
			om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			om.setFilters(filter);
	        Object acc = om.readValue(jsonstr, object.getClass());
	        return acc;
	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	/**
	 * @描述：将json解析为List
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param string 要解析的json字符串
	 * @param x List中元素的字节码文件
	 * @return List
	 */
	public static List<?> parseJson2Collection(String string,Class<?>  x) throws Exception{  
    	ObjectMapper mapper = new ObjectMapper(); 
    	/*mapper.enableDefaultTyping();*/
        JavaType javaType = getCollectionType(List.class, x); 
        List<Class<?>> list =  (List<Class<?>>)mapper.readValue(string, javaType); 
        return list;
    }   
	public static <T> List<T> paseModels(String string,Class<T> x) throws Exception{  
    	ObjectMapper mapper = new ObjectMapper(); 
        JavaType javaType = getCollectionType(ArrayList.class, x); 
        List<T> list =  (List<T>)mapper.readValue(string, javaType); 
        return list;
    }  
	
	/**
	 * 返回传入类型的对象
	 * @author dongchao
	 * @date Aug 5, 2015 8:21:46 PM
	 * @param json 要转义的字符串
	 * @param type eg:HashMap<Stirng,String>
	 * @return
	 * @throws Exception
	 */
	public static <T> T deserialize(String json,TypeReference<T> type) throws Exception{
    	ObjectMapper mapper = new ObjectMapper(); 
    	mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		return mapper.readValue(json, type);
    }
	
	/**
	 * @描述：将json解析为Map
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param string 要解析的json字符串
	 * @return Map
	 */
	public static Map parseJson2Map(String string) throws Exception{
		try {
			ObjectMapper mapper = new ObjectMapper(); 
			return mapper.readValue(string, Map.class);
		} catch (Exception e) {
			throw new  Exception(e.getMessage());
		}
	}
	
	/**
	 * @描述：将json解析为Map
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param string 要解析的json字符串
	 * @param filterMap 过滤器的Map
	 * @return Map
	 */
	public static Map parseJson2Map(String string ,Map<String, String[]> filterMap) throws Exception{
		try {
			ObjectMapper mapper = new ObjectMapper(); 
			SimpleFilterProvider filter = new SimpleFilterProvider().setFailOnUnknownId(false);
			for (Map.Entry<String, String[]> mapItem : filterMap.entrySet()) {
				filter.addFilter(mapItem.getKey(), SimpleBeanPropertyFilter.filterOutAllExcept(mapItem.getValue()));
			}
			mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			mapper.setFilters(filter);
			return mapper.readValue(string, Map.class);
		} catch (Exception e) {
			throw new  Exception(e.getMessage());
		}
	}
	
	/**
	 * @描述：获取泛型的Collection Type 
	 * @开发人员：
	 * @开发时间：2015年7月24日 上午08:00:00
	 * @param collectionClass 泛型的Collection   
     * @param elementClasses 元素类   
     * @return JavaType Java类型   
	 */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
    	ObjectMapper mapper = new ObjectMapper(); 
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
    }
    
    
 
    
//    public static string Serialize<T>(T obj)//序列化为JSON
//    {
//        System.Runtime.Serialization.Json.DataContractJsonSerializer serializer = new System.Runtime.Serialization.Json.DataContractJsonSerializer(obj.GetType());
//        MemoryStream ms = new MemoryStream();
//        serializer.WriteObject(ms, obj);
//        string retVal = Encoding.Default.GetString(ms.ToArray());
//        return retVal;
//    }

    
    
    public static void main(String[] args) {
    	
    	String[] array = new String[]{"3","1","4","","2"};
    	
    	String jArray = JSONUtil.parseObject(array);
    	
    	System.out.println(jArray);
    	
    	try {
			String[] a = JSONUtil.deserialize(jArray, new TypeReference<String[]>(){});
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	
//	     String s = "{ \"name\" : \"张伟龙\", \"sex\" : \"男\", \"age\" : \"23\",\"address\" : \"甘肃金昌\"}";
//	     try {
//	    	 System.out.println(parseJsonToMap(s));
//	     } catch (Exception e) {
//	         e.printStackTrace();
//	     }    
    	
//    	Map map  = new HashMap();
//    	map.put("AA", "aaaaaaa");
//    	map.put("BB", "bbbbbbb");
//    	map.put("CC", "ccccccc");
//    	System.out.println(map);
//    	Map map1  = new HashMap();
//    	map1.put("DD", "dddddd");
//    	map1.put("EE", "eeeeee");
//    	map1.put("FF", "fffff");
//    	List list = new ArrayList();
//    	list.add(map);
//    	list.add(map1);
//    	
//    	System.out.println(list);
    	
    	
    	String json = "{\"head\":{\"element1\":\"value1\",\"element2\":\"value2\",\"element3\":\"value3\",\"element4\":\"value4\"},\"maindetail\":[{\"column0\":\"cvalue01\",\"column1\":\"cvalue02\",\"column2\":\"cvalue03\"},{\"column0\":\"cvalue11\",\"column1\":\"cvalue12\",\"column2\":\"cvalue13\"}]}";
    	
    	//json = "{\"element1\":\"value1\",\"element2\":\"value2\",\"element3\":\"value3\",\"element4\":\"value4\"}";
    	try {
			Map map  = parseJson2Map(json);
			System.out.println(map);
			Map  head =(Map) map.get("head");
			
			ArrayList maindetail =(ArrayList) map.get("maindetail");
			
			System.out.println(head);
			System.out.println(maindetail);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    } 
    
}

