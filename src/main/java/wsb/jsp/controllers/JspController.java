package wsb.jsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wsb.jsp.repositories.CountryRepository;
import wsb.jsp.repositories.PaintingRepository;

@Controller
public class JspController {

    private final PaintingRepository paintingRepository;
    private final CountryRepository countryRepository;

    public JspController(PaintingRepository paintingRepository, CountryRepository countryRepository) {
        this.paintingRepository = paintingRepository;
        this.countryRepository = countryRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping("/countries")
    public ModelAndView countries() {
        ModelAndView modelAndView = new ModelAndView("countries/index");
        modelAndView.addObject("countries", countryRepository.findAll());
        return modelAndView;
    }

    @RequestMapping("/countriesModel")
    public String countriesModel(Model model) {
        model.addAttribute("countries", countryRepository.findAll());
        return "countries/index";
    }

    @RequestMapping("/filteredCountries")
    public ModelAndView filteredCountries(@RequestParam(required = false) Integer minPopulation) {
        if (minPopulation == null) {
            return countries();
        }

        ModelAndView modelAndView = new ModelAndView("countries/index");
        modelAndView.addObject("countries", countryRepository.findAllWithPopulationGreaterThan(minPopulation));
        return modelAndView;
    }

    @RequestMapping("/paintings")
    public ModelAndView paintings(@RequestParam(required = false, defaultValue = "") String paintingName) {
        ModelAndView modelAndView = new ModelAndView("paintings/index");
        modelAndView.addObject("paintings", paintingRepository.findAll(paintingName));
        return modelAndView;
    }



}
