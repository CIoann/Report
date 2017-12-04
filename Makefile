all:
	-pdflatex Thesis
	-bibtex Thesis
	-pdflatex Thesis
	-pdflatex Thesis
	-rm *.aux *.log *.toc *.out *.bbl *.blg
presentation:
	-pdflatex Presentation
	-bibtex Presentation
	-pdflatex Presentation
	-pdflatex Presentation
	-rm *.aux *.log *.toc *.out *.bbl *.blg
	

