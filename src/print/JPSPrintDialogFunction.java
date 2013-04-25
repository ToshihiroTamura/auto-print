//package print;
//
//import javax.print.DocFlavor;
//import javax.print.DocPrintJob;
//import javax.print.PrintException;
//import javax.print.PrintService;
//import javax.print.PrintServiceLookup;
//import javax.print.ServiceUI;
//import javax.print.SimpleDoc;
//import javax.print.attribute.HashPrintRequestAttributeSet;
//import javax.print.attribute.PrintRequestAttributeSet;
//
//public class JPSPrintDialogFunction extends JPSPFunction {
//	//	private String path;
//
//	public JPSPrintDialogFunction() {
//		super();
//	}
//
//	@Override
//	public boolean print() throws PrintException {
//		try {
//
//			//印刷データの提供形式
//
//			DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
//			//印刷要求属性
//			PrintRequestAttributeSet requestAttributeSet = new HashPrintRequestAttributeSet();
//
//			//印刷ダイアログでの出力先一覧
//			PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, requestAttributeSet);
//			//既定で選択される出力先
//			PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
//
//			//印刷ダイアログを表示して選択した出力先を得る
//			PrintService service = ServiceUI.printDialog(null, 100, 100,
//					services, defaultService, flavor, requestAttributeSet);
//			if (service != null) {
//				//印刷ジョブの生成
//				DocPrintJob job = service.createPrintJob();
//				// 印刷ドキュメントの生成
//				SimpleDoc doc = new SimpleDoc(new JpgPrintable(path), flavor, null);
//				//ジョブに印刷を依頼する
//				job.print(doc, requestAttributeSet);
//
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return false;
//		}
//		return true;
//	}
//
//	public void setPath(String path) {
//		super.setPath(path);
//	}
//}
